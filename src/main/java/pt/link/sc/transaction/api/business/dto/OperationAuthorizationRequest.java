package pt.link.sc.transaction.api.business.dto;

import java.math.BigInteger;

import org.joda.money.CurrencyUnit;

import pt.link.sc.transaction.api.common.enums.AuthorizationOperationType;
import pt.link.sc.transaction.api.common.enums.CardIssuer;

public class OperationAuthorizationRequest {
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

    OperationAuthorizationRequest(BigInteger cardSerialNumber, Integer cardTechTypeIdentifier, BigInteger cardNumber, String channelPointId, String channelPointDescription, Long amount, CurrencyUnit currencyCode, AuthorizationOperationType authorizationOperationType, String reason, CardIssuer cardIssuer, Integer productId) {
        this.cardSerialNumber = cardSerialNumber;
        this.cardTechTypeIdentifier = cardTechTypeIdentifier;
        this.cardNumber = cardNumber;
        this.channelPointId = channelPointId;
        this.channelPointDescription = channelPointDescription;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.authorizationOperationType = authorizationOperationType;
        this.reason = reason;
        this.cardIssuer = cardIssuer;
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public BigInteger getCardSerialNumber() {
        return cardSerialNumber;
    }

    public void setCardSerialNumber(BigInteger cardSerialNumber) {
        this.cardSerialNumber = cardSerialNumber;
    }

    public Integer getCardTechTypeIdentifier() {
        return cardTechTypeIdentifier;
    }

    public void setCardTechTypeIdentifier(Integer cardTechTypeIdentifier) {
        this.cardTechTypeIdentifier = cardTechTypeIdentifier;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getChannelPointId() {
        return channelPointId;
    }

    public void setChannelPointId(String channelPointId) {
        this.channelPointId = channelPointId;
    }

    public String getChannelPointDescription() {
        return channelPointDescription;
    }

    public void setChannelPointDescription(String channelPointDescription) {
        this.channelPointDescription = channelPointDescription;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public CurrencyUnit getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyUnit currencyCode) {
        this.currencyCode = currencyCode;
    }

    public AuthorizationOperationType getAuthorizationOperationType() {
        return authorizationOperationType;
    }

    public void setAuthorizationOperationType(AuthorizationOperationType authorizationOperationType) {
        this.authorizationOperationType = authorizationOperationType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CardIssuer getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuer = cardIssuer;
    }
}
