package pt.link.sc.transaction.api.resources.model;

import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pt.link.sc.transaction.api.common.enums.AuthorizationOperationTypeEnum;

@ApiModel(description = "Represents an authorization")
public class OperationAuthorization {

    @ApiModelProperty(value = "The card serial number for the operation in hexadecimal")
    private String cardSerialNumberHexString;

    @ApiModelProperty(value = "The card tech type for the operation", example = "8")
    private Integer cardTechTypeIdentifier;

    @ApiModelProperty(value = "The card number for the operation")
    private BigInteger cardNumber;

    @ApiModelProperty(value = "The amount of the operation")
    private Long amount;

    @ApiModelProperty(value = "Unique identifier of the operation")
    private String uuid;

    @ApiModelProperty(value = "The card currency")
    private String cardCurreny;

    @ApiModelProperty(value = "The date of the operation authorization creation")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdAt;

    @ApiModelProperty(value = "The date the authorization expired")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date autorizationExpirationDate;

    @ApiModelProperty(value = "The card target expiration date ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date targetCardExpirationDate;

    @ApiModelProperty(value = "The type of the operation")
    private AuthorizationOperationTypeEnum type;

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardSerialNumberHexString() {
        return cardSerialNumberHexString;
    }

    public void setCardSerialNumberHexString(String cardSerialNumberHexString) {
        this.cardSerialNumberHexString = cardSerialNumberHexString;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AuthorizationOperationTypeEnum getType() {
        return type;
    }

    public void setType(AuthorizationOperationTypeEnum type) {
        this.type = type;
    }

    public Date getAutorizationExpirationDate() {
        return autorizationExpirationDate;
    }

    public void setAutorizationExpirationDate(Date autorizationExpirationDate) {
        this.autorizationExpirationDate = autorizationExpirationDate;
    }

    public Date getTargetCardExpirationDate() {
        return targetCardExpirationDate;
    }

    public void setTargetCardExpirationDate(Date targetCardExpirationDate) {
        this.targetCardExpirationDate = targetCardExpirationDate;
    }

    public Integer getCardTechTypeIdentifier() {
        return cardTechTypeIdentifier;
    }

    public void setCardTechTypeIdentifier(Integer cardTechTypeIdentifier) {
        this.cardTechTypeIdentifier = cardTechTypeIdentifier;
    }

    public String getCardCurreny() {
        return cardCurreny;
    }

    public void setCardCurreny(String cardCurreny) {
        this.cardCurreny = cardCurreny;
    }

    @Override
    public String toString() {
        return "OperationAuthorization [cardSerialNumberHexString=" + cardSerialNumberHexString + ", cardTechTypeIdentifier=" + cardTechTypeIdentifier + ", cardNumber=" + cardNumber + ", amount=" + amount + ", uuid=" + uuid + ", createdAt=" + createdAt + ", autorizationExpirationDate=" + autorizationExpirationDate
                + ", targetCardExpirationDate=" + targetCardExpirationDate + ", type=" + type + "]";
    }

}
