package pt.link.sc.transaction.api.common.util;

import java.math.BigInteger;

public class CardId {
    private BigInteger cardSerialNumber;
    private Integer cardTechType;

    public BigInteger getCardSerialNumber() {
        return cardSerialNumber;
    }

    public void setCardSerialNumber(BigInteger cardSerialNumber) {
        this.cardSerialNumber = cardSerialNumber;
    }

    public Integer getCardTechType() {
        return cardTechType;
    }

    public void setCardTechType(Integer cardTechType) {
        this.cardTechType = cardTechType;
    }

    public CardId() {
        super();
    }

    public CardId(BigInteger cardSerialNumber, Integer cardTechType) {
        super();
        this.cardSerialNumber = cardSerialNumber;
        this.cardTechType = cardTechType;
    }

}
