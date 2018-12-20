package pt.link.sc.transaction.api.business.service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pt.link.sc.transaction.api.business.dto.CardAuthorizationResultDto;
import pt.link.sc.transaction.api.business.dto.CardInformationDto;
import pt.link.sc.transaction.api.business.dto.CardOperationResultDto;
import pt.link.sc.transaction.api.business.dto.OperationAuthorizationRequest;
import pt.link.sc.transaction.api.business.entity.AuthorizationEO;
import pt.link.sc.transaction.api.business.entity.CardEO;
import pt.link.sc.transaction.api.business.entity.TransactionEO;
import pt.link.sc.transaction.api.business.exceptions.InvalidOperationException;
import pt.link.sc.transaction.api.common.enums.AuthorizationOperationType;
import pt.link.sc.transaction.api.common.enums.AuthorizationStatus;
import pt.link.sc.transaction.api.common.enums.CardTechType;
import pt.link.sc.transaction.api.common.enums.EnumUtil;
import pt.link.sc.transaction.api.common.enums.InvalidOperationCode;
import pt.link.sc.transaction.api.common.enums.ThreeState;
import pt.link.sc.transaction.api.common.enums.ReloadTransactionType;
import pt.link.sc.transaction.api.common.util.CardId;
import pt.link.sc.transaction.api.common.util.CryptoUtil;
import pt.link.sc.transaction.api.resources.model.ReloadTransaction;

@Service
public class CardAuthorizationService extends AbstractService {

    @Transactional
    public CardAuthorizationResultDto requestCardOperationAuthorization(OperationAuthorizationRequest operationAuthorizationRequest) {

        CardId cardId = new CardId(operationAuthorizationRequest.getCardSerialNumber(), operationAuthorizationRequest.getCardTechTypeIdentifier());

        final CardEO card = genericCardService.getCardByCardSerialNumber(cardId)
                .orElseThrow(() ->
                        new InvalidOperationException(InvalidOperationCode.CARD_NOT_FOUND__TWO_ARGS, new Object[]{
                                CryptoUtil.bigIntegerToHexString(operationAuthorizationRequest.getCardSerialNumber()),
                                EnumUtil.getById(operationAuthorizationRequest.getCardTechTypeIdentifier(), CardTechType.class)
                                        .map(CardTechType::getName)
                                        .orElse(CardTechType.UNKNOWN.getName())}));
        
    	AuthorizationOperationType authorizationOperationType = Optional.ofNullable(operationAuthorizationRequest.getAuthorizationOperationType())
                .orElseThrow(() -> new InvalidOperationException(InvalidOperationCode.UNNEXPECTED_OPERATION__ONE_ARG, new Object[]{operationAuthorizationRequest.getAuthorizationOperationType()}));

        authorizationOperationType.validateAuthoriationRequestParameters(operationAuthorizationRequest);
        
        //Associate the authorization by card logical. If it is an operation that does not use a logical card, then use the card.
        AuthorizationEO newAuthorization = new AuthorizationEO();
        newAuthorization.setCard(card);
        newAuthorization.setAmount(operationAuthorizationRequest.getAmount());
        newAuthorization.setAuthorizationExpirationDate(cardExpirationService.getExpirationDateForStartDate(new Date()));
        newAuthorization.setAuthorizationOperationType(authorizationOperationType);
        newAuthorization.setAuthorizationStatus(AuthorizationStatus.NOT_PERFORMED);
        newAuthorization.setUuid(UUID.randomUUID().toString());
        newAuthorization.setCardExpirationDate(cardExpirationService.getExpirationDateForStartDate(new Date()));
        newAuthorization.setReason(operationAuthorizationRequest.getReason());
        
        channelPointService.findOrCreate(operationAuthorizationRequest.getChannelPointId(), operationAuthorizationRequest.getChannelPointDescription()).ifPresent(newAuthorization::setChannelPoint);

        newAuthorization = authorizationRepository.save(newAuthorization);
        return CardAuthorizationResultDto.builder().withResultedAuthorization(newAuthorization).build();
    }

    @Transactional
    public CardOperationResultDto performAuthorizedCardOperation(String authorizationUuid, Date performedOnDate, ReloadTransaction apiTransaction) {
        final Optional<AuthorizationEO> authorization;
     
        if (authorizationUuid != null) {
            authorization = Optional.ofNullable(authorizationRepository.findAuthorizationByUUID(authorizationUuid));
        } else {
            authorization = Optional.empty();
        }
        
/* TODO: Authorizations need to be defined first
        if (authorization.isPresent()) {
            Collection<ReloadTransactionType> allowedTransactionsTypes = authorization.get().getAuthorizationOperationType().getAllowedTransactionsTypes();
            if (ThreeState.MUST_EXIST == authorization.get().getAuthorizationOperationType().getTransactionExistence() && apiTransaction == null) {
                throw new InvalidOperationException(InvalidOperationCode.MUST_HAVE_TRANSACTION__ONE_ARG, new Object[]{allowedTransactionsTypes});
            }
        }*/
        
        AuthorizationEO savedAuthorization;
        if (authorization.isPresent()) {
            authorization.get().setAuthorizationStatus(AuthorizationStatus.PERFORMED);
            authorization.get().setPerformedOn(performedOnDate);
            savedAuthorization = authorizationRepository.save(authorization.get());
        } else {
            savedAuthorization = null;
        }
        
        TransactionEO cardTransaction = null;
        if (apiTransaction != null) {
            cardTransaction = cardMapper.mapToEntityTransaction(apiTransaction, authorization.map(AuthorizationEO::getChannelPoint).orElse(null));
            if (savedAuthorization != null) {
                cardTransaction.setAuthorization(savedAuthorization);
            }

            cardTransaction = cardTransactionService.registerCardTransaction(cardTransaction);
        }

        CardInformationDto cardInformation = null;
        
        return CardOperationResultDto.builder().withCardCurrentInformationDto(cardInformation).withGeneratedWarnings(null).build();
    }
}
