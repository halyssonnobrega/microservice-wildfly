package pt.link.sc.transaction.api.common.util;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pt.link.sc.transaction.api.business.dto.CardAuthorizationResultDto;
import pt.link.sc.transaction.api.business.dto.CardInformationDto;
import pt.link.sc.transaction.api.business.entity.AuthorizationEO;
import pt.link.sc.transaction.api.business.entity.ChannelPointEO;
import pt.link.sc.transaction.api.business.entity.TransactionEO;
import pt.link.sc.transaction.api.resources.model.CardInformation;
import pt.link.sc.transaction.api.resources.model.OperationAuthorization;
import pt.link.sc.transaction.api.resources.model.ReloadTransaction;

@Service
public class CardMapper {

    private Logger log = LoggerFactory.getLogger(this.getClass());
	
    public OperationAuthorization mapToOperationAuthorization(CardAuthorizationResultDto cardOperationDto) {
        AuthorizationEO authorization = cardOperationDto.getResultedAuthorization();

        OperationAuthorization oa = new OperationAuthorization();
//        oa.setCardSerialNumberHexString(CryptoUtil.bigIntegerToHexString(authorization.getPhysicalCard().getCardSerialNumber()));
//        oa.setCardTechTypeIdentifier(authorization.getPhysicalCard().getCardTechTypeId());
//        if (authorization.getLogicalCard() != null) {
//            oa.setCardNumber(authorization.getLogicalCard().getCardNumber());
//        }
//        oa.setCreatedAt(authorization.getCreatedOnDate());
//        oa.setAmount(authorization.getAmount());
//        oa.setUuid(authorization.getUuid());
//        oa.setAutorizationExpirationDate(authorization.getAuthorizationExpirationDate());
//        oa.setTargetCardExpirationDate(authorization.getCardExpirationDate());
//        oa.setCardCurreny(authorization.getCurrencyCode());
//        oa.setType(EnumUtil.fromMappingRelation(AuthorizationOperationTypeEnum.class, authorization.getAuthorizationOperationType()));
        return oa;
    }

    public CardInformation mapToCardInformation(CardInformationDto cardInformation) {
        CardInformation ci = new CardInformation();
//        ci.setCardId(mapToCardId(cardInformation.getLogicalCard()));
//        ci.setContractInformation(cardInformation.getCardContracts().stream().map(this::mapToContractInformation).collect(Collectors.toList()));
//        ci.setCurrencyCode(cardInformation.getLogicalCard().getCurrencyCode());
//        ci.setActivationDate(cardInformation.getLogicalCard().getPhysicalCard().getActivationDate());
//        ci.setCardStatus(EnumUtil.fromMappingRelation(CardStatusEnum.class, cardInformation.getLogicalCard().getPhysicalCard().getCardStatus()));
//        ci.setExpirationDate(cardInformation.getLogicalCard().getPhysicalCard().getExpirationDate());
        return ci;
    }

//    private ContractInformation mapToContractInformation(CardContract cardContract) {
//        ContractInformation ci = new ContractInformation();
//        ci.setContractPointer(cardContract.getProductId());
//        ci.setConsolidatedContractBalance(cardContract.getConsolidatedBalance());
//        ci.setContractBalance(cardContract.getLastBalance());
//        return ci;
//    }

//    private CardId mapToCardId(LogicalCard logicalCard) {
//        CardId c = new CardId();
//        c.setCardNumber(logicalCard.getCardNumber());
//        c.setCardSerialNumberHexString(CryptoUtil.bigIntegerToHexString(logicalCard.getPhysicalCard().getCardSerialNumber()));
//        c.setCardTypeIdentifier(logicalCard.getPhysicalCard().getCardTechTypeId());
//        c.setCardIdentifier(CryptoUtil.toCardIdentifier(logicalCard.getPhysicalCard().getCardId()));
//        return c;
//    }
//
//    public TransactionEO mapToCardTransaction(CardTransaction cardTransaction) {
//        TransactionEO ct = new TransactionEO();
//
//        ct.setCardId(mapToCardId(cardTransaction.getLogicalCard()));
//        ct.setAmount(cardTransaction.getAmount());
//        Optional.ofNullable(cardTransaction.getContract())
//                .map(CardContract::getProductId)
//                .ifPresent(ct::setContractPointer);
//        ct.setFinalBalance(cardTransaction.getFinalBalance());
//        ct.setMacBase64(cardTransaction.getMacBase64());
//        ct.setBcscCreatedOnDate(cardTransaction.getCreatedOnDate());
//        ct.setBcscStatus(cardTransaction.getBackofficeTransactionStatus().getName());
//        ct.setTransactionDate(cardTransaction.getTransactionDate());
//        ct.setTransactionId(cardTransaction.getTransactionId());
//        ct.setProduct(mapToProduct(cardTransaction));
//        ct.setTransactionStatus(cardTransaction.getTransactionStatusId());
//        ct.setTransactionType(cardTransaction.getTransactionTypeId());
//        ct.setTransactionSubType(cardTransaction.getTransactionSubType());
//        ct.setCorrelationId(cardTransaction.getCorrelationId());
//
//        ct.setCsv(cardTransaction.getCsv());
//        if (cardTransaction.getMachine() != null) {
//            ct.setMachineCode(cardTransaction.getMachine().getMachineCode());
//        }
//
//        if (cardTransaction.getProduct() != null) {
//            ct.setProduct(new Product());
//            ct.getProduct().setProductId(cardTransaction.getProduct().getId());
//            ct.getProduct().setProductName(cardTransaction.getProduct().getProductName());
//            ct.getProduct().setProductType(cardTransaction.getProduct().getProductType());
//        }
//
//        if (cardTransaction.getRoute() != null) {
//            if (ct.getLocation() == null) {
//                ct.setLocation(new Location());
//            }
//            ct.getLocation().setRouteDescription(cardTransaction.getRoute().getDescription());
//            ct.getLocation().setRouteId(cardTransaction.getRoute().getId());
//        }
//
//        if (cardTransaction.getRun() != null) {
//            if (ct.getLocation() == null) {
//                ct.setLocation(new Location());
//            }
//            ct.getLocation().setRunDescription(cardTransaction.getRun().getDescription());
//            ct.getLocation().setRunId(cardTransaction.getRun().getId());
//        }
//
//        if (cardTransaction.getStop() != null) {
//            if (ct.getLocation() == null) {
//                ct.setLocation(new Location());
//            }
//            ct.getLocation().setStopDescription(cardTransaction.getStop().getDescription());
//            ct.getLocation().setStopId(cardTransaction.getStop().getId());
//        }
//
//        if (cardTransaction.getChannelPoint() != null) {
//            if (ct.getLocation() == null) {
//                ct.setLocation(new Location());
//            }
//            ct.getLocation().setLocationDescription(cardTransaction.getChannelPoint().getExternalId());
//        }
//
//        ct.setOperationTimestamp(cardTransaction.getOperationTimestamp());
//
//        return ct;
//    }
//
//    private Product mapToProduct(CardTransaction cardTransaction) {
//        Product p = new Product();
//
//        pt.link.sc.bcsc.business.entities.Product product = cardTransaction.getProduct();
//        if (product != null) {
//            p.setProductId(product.getId());
//            p.setProductName(product.getProductName());
//            p.setProductType(product.getProductType());
//        }
//        return p;
//    }
//
//    public Event mapToCardEvent(CardEvent cardEvent) {
//        Event ce = new Event();
//        ce.setCardId(mapToCardId(cardEvent.getLogicalCard()));
//        ce.setEventDate(cardEvent.getEventDate());
//        if (cardEvent.getCardEventType() != null && cardEvent.getCardEventType() != null) {
//            ce.setCardEventType(EnumUtil.fromMappingRelation(CardEventTypeEnum.class, cardEvent.getCardEventType()));
//        }
//        ce.setReason(cardEvent.getReason());
//        return ce;
//    }
//
//    public CardKeyResponse mapToCardKeyResponse(List<DiversifiedKeyDto> cardKeys) {
//        CardKeyResponse cardKeyResponse = new CardKeyResponse();
//
//        List<CardKey> collect = cardKeys.stream().map(this::mapToCardKey).collect(Collectors.toList());
//        cardKeyResponse.setCardKeys(collect);
//        return cardKeyResponse;
//    }
//
//    private CardKey mapToCardKey(DiversifiedKeyDto key) {
//        CardKey ck = new CardKey();
//        ck.setKeyDescription(key.getKeyType().getName());
//        ck.setKeyHexString(Hex.toHexString(key.getKeyValue()).toUpperCase());
//        ck.setKeyNumber(key.getKeyNumber());
//        return ck;
//    }

    public TransactionEO mapToEntityTransaction(ReloadTransaction cardTransaction, ChannelPointEO channelPoint) {

    	TransactionEO transaction = new TransactionEO();
    	transaction.setCardDataModelId(cardTransaction.getCardDataModel());
    	transaction.setCardNumber(cardTransaction.getCardNumb());
    	transaction.setCardPhysicalTypeId(cardTransaction.getCardPhysicalType());
    	transaction.setCardSerialNumber(CryptoUtil.toCardSerialNumber(cardTransaction.getCardSerialNumberHexString()));
    	transaction.setChannelPoint(channelPoint);
    	transaction.setComission(cardTransaction.getComission());
    	transaction.setContractBinary(cardTransaction.getLoadContract());
    	transaction.setContractPosition(cardTransaction.getContractIndex());
    	transaction.setCorrCardDataModelId(cardTransaction.getCorrCardDataModel());
    	transaction.setCorrCardNumber(cardTransaction.getCorrCardNumber());
    	transaction.setCorrCardSerialNumber(CryptoUtil.toCardSerialNumber(cardTransaction.getCorrCardSerialNumberHexString()));
    	transaction.setLoadOper(cardTransaction.getLoadOper());
    	transaction.setPrice(cardTransaction.getPrice());
    	transaction.setCorrPrice(cardTransaction.getCorrPrice());
    	transaction.setCorrTickCode(cardTransaction.getCorrTickCode());
    	transaction.setCorrTickOperCode(cardTransaction.getCorrTickOperCode());
    	transaction.setCorrTickReloadMachineCode(cardTransaction.getCorrTickReloMachCode());
    	transaction.setCorrTickReloadNumberDaily(cardTransaction.getCorrTickReloNumbDaily());
    	transaction.setCorrTransactionIdentifier(cardTransaction.getCorrTransactionID());
    	transaction.setEntityId(cardTransaction.getEntity());
    	transaction.setFirstDateTimeEntrance(cardTransaction.getFirstDateTimeEntrance());
    	transaction.setFiscalNumber(cardTransaction.getFiscalNr());
    	transaction.setGroupId(cardTransaction.getGroupId());
    	transaction.setInvoiceNumber(cardTransaction.getInvoiceNr());
    	transaction.setPaymentMean(cardTransaction.getPaymMean());
    	transaction.setPinBlock(cardTransaction.getPinBlock());
    	transaction.setPosId(cardTransaction.getPosId());
    	transaction.setPreviousContractBinary(cardTransaction.getPreviousContract());
    	transaction.setTicketCode(cardTransaction.getTickCode());
    	transaction.setTicketOperatorCode(cardTransaction.getTickOperCode());
    	transaction.setTicketReloadDate(cardTransaction.getTickReloDate());
    	transaction.setTicketReloadMachineCode(cardTransaction.getTickReloMachCode());
    	transaction.setTicketReloadNumberDaily(cardTransaction.getTickReloNumbDaily());
    	transaction.setTransactionDate(cardTransaction.getTransactionDate());
    	transaction.setVinhSeriNr(cardTransaction.getVinhSeriNumb());
    	transaction.setUuid(UUID.randomUUID().toString());
    	transaction.setQuantity(cardTransaction.getLoadedQuantity()); // getLoadedQuantity / getProductQuantity
    	
    	//transaction.setTransactionType();
    	//transaction.setTransactionState();
    	//transaction.setTransactionProfiles();
    	
    	//transaction.setTransactionStatesReason();
    	//transaction.setNetworkCode(); 
    	//transaction.setOfflineCardOperation();
    	
    	//transaction.setCreatedByUser();
    	transaction.setCreatedOnDate(new Date());
    	//transaction.setLastModifiedByUser();
    	transaction.setLastModifiedDate(new Date());

        return transaction;
    }
}