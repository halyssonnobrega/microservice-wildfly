package pt.link.sc.transaction.api.resources.online;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.joda.money.CurrencyUnit;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import pt.link.sc.transaction.api.business.dto.CardAuthorizationResultDto;
import pt.link.sc.transaction.api.business.dto.CardInformationDto;
import pt.link.sc.transaction.api.business.dto.CardOperationResultDto;
import pt.link.sc.transaction.api.business.dto.OperationAuthorizationRequest;
import pt.link.sc.transaction.api.business.dto.OperationAuthorizationRequestBuilder;
import pt.link.sc.transaction.api.business.entity.ChannelPointEO;
import pt.link.sc.transaction.api.business.entity.TransactionEO;
import pt.link.sc.transaction.api.business.exceptions.InvalidOperationException;
import pt.link.sc.transaction.api.business.service.CardAuthorizationService;
import pt.link.sc.transaction.api.business.service.ChannelPointService;
import pt.link.sc.transaction.api.business.service.GenericCardService;
import pt.link.sc.transaction.api.common.enums.AuthorizationOperationType;
import pt.link.sc.transaction.api.common.enums.CardIssuer;
import pt.link.sc.transaction.api.common.enums.EnumUtil;
import pt.link.sc.transaction.api.common.enums.InvalidOperationCode;
import pt.link.sc.transaction.api.common.util.CardMapper;
import pt.link.sc.transaction.api.common.util.CryptoUtil;
import pt.link.sc.transaction.api.common.util.CsvUtil;
import pt.link.sc.transaction.api.common.util.JavaUtils;
import pt.link.sc.transaction.api.common.validationGroups.ActivationGroup;
import pt.link.sc.transaction.api.common.validationGroups.DestructionGroup;
import pt.link.sc.transaction.api.common.validationGroups.RechargeGroup;
import pt.link.sc.transaction.api.common.validationGroups.RefundGroup;
import pt.link.sc.transaction.api.common.validationGroups.RehabilitatedGroup;
import pt.link.sc.transaction.api.resources.model.AuthorizationRequest;
import pt.link.sc.transaction.api.resources.model.AuthorizedCardOperation;
import pt.link.sc.transaction.api.resources.model.CardInformation;
import pt.link.sc.transaction.api.resources.model.CsvTransactions;
import pt.link.sc.transaction.api.resources.model.OperationAuthorization;
import pt.link.sc.transaction.api.resources.model.OperationResult;
import pt.link.sc.transaction.api.resources.model.ReloadTransaction;

@RestController
@RequestMapping("/api/online/transaction")
@Api(tags = {"Transactions"}, authorizations = {@Authorization(value = "OAuth2-Enterprise", scopes =
{@AuthorizationScope(description = "Enterpise", scope = "public"),})}
)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class TransactionsRest {

    @Inject
    private CardAuthorizationService cardAuthorizationService;
    
	@Inject
    private ChannelPointService channelPointService;
	
	@Inject
	private CardMapper cardMapper;
	
	@Inject
	private GenericCardService genericCardService;
	
	@RequestMapping(value = "/authorize", method = RequestMethod.POST)
    @ApiOperation(nickname = "authorize", value = "Requests an authorization for a card operation.", notes = "Requests an authorization for a card. "
            + "This service will return an operation authorization with an uuid if the operation can be performed."
            + "\n"
            + "\n Allowed operations are: "
            + "\n - 'activation' - Activation can only be performed on resellers and agencys on distributed cards."
            + "\n - 'refund' - Refund can only be performed on active cards within a period defined on the BCSC system."
            + "\n - 'recharge' - Recharge operation can only be performed on active cards and it cannot exceed a balance value defined on the BCSC system."
            + "\n - 'destruction' - Destruction operation can be performed on blacklisted, invalidated, expired, active or refunded cards."
            + "\n - 'rehabilitation' - Rehabilitated operation can only be performed on invalidated cards."
            + "\n"
            + "\n For activation operations the targetCardExpirationDate with the target card expiration date and the card number for the card will be returned."
            + "\n The cardOperationKey will be returned with the necessary key for the operation."
            + "\n"
            + "\n - authorizationOperationType: Authorization operation type is the desired operation to be performed on the card. Each operation type has it own set of validations for the card such as required card status, allowed channel type and authorization request fields."
            + "\n - cardSerialNumberHexString : The card serial number that will be the target of the operation. The value is a hexadecimal string."
            + "\n - cardTechTypeIdentifier: The card tech type that will be the target of the operation."
            + "\n - cardNumber: The card number is required for the recharge operation. For other operations it should be empty."
            + "\n - targetAmount: The target amount is required for the recharge operation and indicates the amount of recharge that is desired. For other operations it should be empty. Value is in cents."
            + "\n - contractPointerId: The target contractPointerId is required for the recharge operation and indicates the product for the recharge that is desired. For other operations it should be empty."
            + "\n - reason: The reason is a free text field that can be used to describe why the operation is being performed."
            + "\n - targetCurrencyCode: The target currency code is required for the card activation or card load. The activated card will use that currency afterwards."
            + "\n - cardIssuer: The issuer that is activating the card. This is required for activation operations. 1 for TPG."
            + "\n - channelType: The channel type represents what channel is performing the card operation."
            + "\n - channelPointDescription: The location where this operation is being performed.")
    public OperationAuthorization authorization(@RequestBody @ApiParam(required = true, name = "authorizatonRequest", value = "The request information for the card authorization.") 
    											@Valid AuthorizationRequest authorizationRequest ) {//, @ApiParam(hidden = true) ExtendedUserInfo userInfo) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<AuthorizationRequest>> validate;

        authorizationRequest.initFromCardInfo();

        switch (authorizationRequest.getAuthorizationOperationType()) {
            case RELOAD_AUTH:
                validate = validator.validate(authorizationRequest, ActivationGroup.class);
                break;
            default:
                throw new InvalidOperationException(InvalidOperationCode.UNNEXPECTED_OPERATION__ONE_ARG, new Object[]{authorizationRequest.getAuthorizationOperationType()});
        }

        if (validate != null && !validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }

        AuthorizationOperationType operationType = EnumUtil.getByName(authorizationRequest.getAuthorizationOperationType().value(), AuthorizationOperationType.class).orElseThrow(() -> new InvalidOperationException(InvalidOperationCode.INVALID_MAPPING__ONE_ARG, new Object[]{"operation type"}));

        Optional<String> currency = JavaUtils.resolve(() -> authorizationRequest.getTargetCurrencyCode().value());

        CurrencyUnit currencyUnit;
        try {
            currencyUnit = currency.map(CurrencyUnit::of).orElse(null);
        } catch (Exception e) {
            throw new InvalidOperationException(InvalidOperationCode.UNEXPECTED_CURRENCY__ONE_ARG, new Object[]{currency.orElse(null)});
        }

        CardIssuer cardIssuer = null;
        if (authorizationRequest.getCardIssuer() != null) {
            cardIssuer = EnumUtil.getById(authorizationRequest.getCardIssuer(), CardIssuer.class).orElseThrow(() -> new InvalidOperationException(InvalidOperationCode.INVALID_MAPPING__ONE_ARG, new Object[]{"cardIssuer"}));
        }

        OperationAuthorizationRequest operationAuthorizationRequest = new OperationAuthorizationRequestBuilder()
                .setCardSerialNumber(CryptoUtil.toCardSerialNumber(authorizationRequest.getCardSerialNumberHexString()))
                .setCardNumber(authorizationRequest.getCardNumber())
                .setCardTechTypeIdentifier(authorizationRequest.getCardTechTypeIdentifier())
                .setChannelPointId(authorizationRequest.getChannelPointId())
                .setChannelPointDescription(authorizationRequest.getChannelPointDescription())
                .setAmount(authorizationRequest.getTargetAmount())
                .setCurrencyCode(currencyUnit)
                .setAuthorizationOperationType(operationType)
                .setReason(authorizationRequest.getReason())
                .setProductId(authorizationRequest.getContractPointerId())
                .setCardIssuer(cardIssuer)
                .createOperationAuthorizationRequest();

        CardAuthorizationResultDto operationResult = cardAuthorizationService.requestCardOperationAuthorization(operationAuthorizationRequest);
    	return cardMapper.mapToOperationAuthorization(operationResult);
    }

	@RequestMapping(value = "/commit", method = RequestMethod.POST)
    @ApiOperation(nickname = "commit", value = "Commits an authorized operation", notes = "Commits an authorized operation on a card. "
            + "\n Some operations requires a card transaction. These are:"
            + "\n - Activation - Requires a personalization activation transaction"
            + "\n - Refund - Can have a debit transaction but it is not required."
            + "\n - Destruction - Cannot have a card transaction"
            + "\n - Recharge - requires a load transaction"
            + "\n - Rehabilitation -  Requires a personalization rehabilitation transaction"
            + "\n "
            + "\n Will validate the sent information with the authorization. If the information is not valid the operation and any associated transaction will not be registed."
            + "\n Only some channels can perform some operations:"
            + "\n - Activation - Agencies and resellers"
            + "\n - Refund - Agencies"
            + "\n - Destruction - Agencies"
            + "\n - Recharge - Agencies, resellers and bss"
            + "\n - Rehabilitation - Agencies"
            + "\n "
            + "\n The transaction types are:"
            + "\n - 1 - Load "
            + "\n - 4 - Invalidation"
            + "\n - 5 - Personalization"
            + "\n - 6 - Debit")
    public CardInformation commit(@RequestBody @ApiParam(required = true, name = "authorizedCardOperation", value = "The information regarding the authorized and performed card operation") 
            @Valid AuthorizedCardOperation authorizedCardOperation) {

        Assert.notNull(authorizedCardOperation, "authorizedCardOperation is required");

        ReloadTransaction transaction = null;
        if (authorizedCardOperation.getCsvTransaction() != null && StringUtils.isNotBlank(authorizedCardOperation.getCsvTransaction().getCsv())) {
            transaction = (ReloadTransaction) CsvUtil.processCsv(authorizedCardOperation.getCsvTransaction().getCsv(),  authorizedCardOperation.getCsvTransaction().getCorrelationId(), authorizedCardOperation.getCsvTransaction().getLocationDescription());
        }

        if (transaction != null) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<ReloadTransaction>> validate = validator.validate(transaction);
            if (validate != null && !validate.isEmpty()) {
                throw new ConstraintViolationException(validate);
            }
        }

        CardOperationResultDto operationResult = cardAuthorizationService.performAuthorizedCardOperation(authorizedCardOperation.getAuthorizationUuid(), authorizedCardOperation.getPerformedOnDate(), transaction);
        Optional<CardInformationDto> optionalCardInformationDto = Optional.ofNullable(operationResult).map(CardOperationResultDto::getCardCurrentInformationDto);
    	return optionalCardInformationDto.map(cardInformationDto -> cardMapper.mapToCardInformation(cardInformationDto)).orElse(null);
    }

    /**
     * In truth, this method registers csv transactions of all types. Transactions that requires authorization will latter be marked as invalid.
     */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(nickname = "register", value = "Registers card transactions", notes = "Registers performed cards transactions. Only accepts debit (type 6) and invalidation (type 4) transactions only.")
    public OperationResult transactions(@RequestBody @ApiParam(name = "cvsTransactions", value = "The csv of the transactions") @Valid CsvTransactions csvTransactions) {

        Assert.notNull(csvTransactions, "csvTransactions is required");
        Assert.notNull(csvTransactions.getCsvTransactions(), "csvTransactions list is required");
        List<ReloadTransaction> transactions = csvTransactions.getCsvTransactions().stream().map(x -> (ReloadTransaction) CsvUtil.processCsv(x.getCsv(), x.getCorrelationId(), x.getLocationDescription())).collect(Collectors.toList());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ReloadTransaction>> validate = new HashSet<>();
        for (ReloadTransaction t : transactions) {
            validate.addAll(validator.validate(t));
        }

        if (!validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }

        ChannelPointEO channelPoint = channelPointService.mapToChannelPoint(csvTransactions.getChannelPointId(), csvTransactions.getChannelPointDescription()).orElse(null);
        List<TransactionEO> mappedCardTransactions = transactions.stream().map(cardTransaction -> cardMapper.mapToEntityTransaction(cardTransaction, channelPoint)).collect(Collectors.toList());

        CardOperationResultDto operationResult = genericCardService.registerCardTransactions(mappedCardTransactions);        
        return new OperationResult(Status.OK.getStatusCode(), operationResult.getGeneratedWarnings());
	}
}
