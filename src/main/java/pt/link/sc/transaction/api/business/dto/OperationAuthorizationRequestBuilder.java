package pt.link.sc.transaction.api.business.dto;

import java.math.BigInteger;

import org.joda.money.CurrencyUnit;

import pt.link.sc.transaction.api.common.enums.AuthorizationOperationType;
import pt.link.sc.transaction.api.common.enums.CardIssuer;

public class OperationAuthorizationRequestBuilder {
    private BigInteger cardSerialNumber;
    private Integer cardTechTypeIdentifier;
    private BigInteger cardNumber;
    private String channelPointId;
    private String channelPointDescription;
    private Long amount;
    private CurrencyUnit currencyCode;
    private AuthorizationOperationType authorizationOperationType;
    private String reason;
    private CardIssuer cardIssuer;
    private Integer productId;

    public OperationAuthorizationRequestBuilder setCardSerialNumber(BigInteger cardSerialNumber) {
        this.cardSerialNumber = cardSerialNumber;
        return this;
    }

    public OperationAuthorizationRequestBuilder setCardTechTypeIdentifier(Integer cardTechTypeIdentifier) {
        this.cardTechTypeIdentifier = cardTechTypeIdentifier;
        return this;
    }

    public OperationAuthorizationRequestBuilder setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public OperationAuthorizationRequestBuilder setChannelPointId(String channelPointId) {
        this.channelPointId = channelPointId;
        return this;
    }

    public OperationAuthorizationRequestBuilder setChannelPointDescription(String channelPointDescription) {
        this.channelPointDescription = channelPointDescription;
        return this;
    }

    public OperationAuthorizationRequestBuilder setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public OperationAuthorizationRequestBuilder setCurrencyCode(CurrencyUnit currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public OperationAuthorizationRequestBuilder setAuthorizationOperationType(AuthorizationOperationType authorizationOperationType) {
        this.authorizationOperationType = authorizationOperationType;
        return this;
    }

    public OperationAuthorizationRequestBuilder setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public OperationAuthorizationRequestBuilder setCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuer = cardIssuer;
        return this;
    }

    public OperationAuthorizationRequestBuilder setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public OperationAuthorizationRequest createOperationAuthorizationRequest() {
        return new OperationAuthorizationRequest(cardSerialNumber, cardTechTypeIdentifier, cardNumber, channelPointId, channelPointDescription, amount, currencyCode, authorizationOperationType, reason, cardIssuer, productId);
    }
}