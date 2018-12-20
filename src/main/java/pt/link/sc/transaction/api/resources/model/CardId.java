package pt.link.sc.transaction.api.resources.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@ApiModel(value = "Contains the information that allows to identify the card")
public class CardId {

    @ApiModelProperty(value = "The card serial number in hexadecimal", allowEmptyValue = false, example = "0433458AD55197")
    @NotNull
    private String cardSerialNumberHexString;

    @ApiModelProperty(value = "The card type identifier. DESFIRE corresponds to the value 8", allowEmptyValue = false, example = "8")
    @NotNull
    private Integer cardTypeIdentifier;

    @ApiModelProperty(value = "The card identifier.", example = "08000433458AD55197")
    @NotNull
    private String cardIdentifier;

    @ApiModelProperty(value = "The card number", allowEmptyValue = false)
    @NotNull
    private BigInteger cardNumber;

    public String getCardSerialNumberHexString() {
        return cardSerialNumberHexString;
    }

    public void setCardSerialNumberHexString(String cardSerialNumberHexString) {
        this.cardSerialNumberHexString = cardSerialNumberHexString;
    }

    public Integer getCardTypeIdentifier() {
        return cardTypeIdentifier;
    }

    public void setCardTypeIdentifier(Integer cardTypeIdentifier) {
        this.cardTypeIdentifier = cardTypeIdentifier;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    @NotNull
    public String getCardIdentifier() {
        return cardIdentifier;
    }

    public void setCardIdentifier(@NotNull String cardIdentifier) {
        this.cardIdentifier = cardIdentifier;
    }

    @Override
    public String toString() {
        return "CardId [cardSerialNumberHexString=" + cardSerialNumberHexString + ", cardTypeIdentifier=" + cardTypeIdentifier + ", cardNumber=" + cardNumber + "]";
    }


}