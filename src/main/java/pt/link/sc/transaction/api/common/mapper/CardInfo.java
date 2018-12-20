
package pt.link.sc.transaction.api.common.mapper;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cardTechType",
        "cardValidityState",
        "cardSerialNumber",
        "cardNumber",
        "cardInBlackListFlag",
        "cardIsCleanFlag"
})
public class CardInfo implements Serializable {

    @JsonProperty("cardValidityState")
    private Long cardValidityState;
    @JsonProperty("cardTechType")
    private Integer cardTechType;
    @JsonProperty("cardSerialNumber")
    private CardSerialNumber cardSerialNumber;
    @JsonProperty("cardNumber")
    private CardNumber cardNumber;
    @JsonProperty("cardInBlackListFlag")
    private Boolean cardInBlackListFlag;
    @JsonProperty("cardIsCleanFlag")
    private Boolean cardIsCleanFlag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4275457460907420490L;

    @JsonProperty("cardTechType")
    public Integer getCardTechType() {
        return cardTechType;
    }

    @JsonProperty("cardTechType")
    public void setCardTechType(Integer cardTechType) {
        this.cardTechType = cardTechType;
    }


    @JsonProperty("cardValidityState")
    public Long getCardValidityState() {
        return cardValidityState;
    }

    @JsonProperty("cardValidityState")
    public void setCardValidityState(Long cardValidityState) {
        this.cardValidityState = cardValidityState;
    }

    @JsonProperty("cardSerialNumber")
    public CardSerialNumber getCardSerialNumber() {
        return cardSerialNumber;
    }

    @JsonProperty("cardSerialNumber")
    public void setCardSerialNumber(CardSerialNumber cardSerialNumber) {
        this.cardSerialNumber = cardSerialNumber;
    }

    @JsonProperty("cardNumber")
    public CardNumber getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("cardInBlackListFlag")
    public Boolean getCardInBlackListFlag() {
        return cardInBlackListFlag;
    }

    @JsonProperty("cardInBlackListFlag")
    public void setCardInBlackListFlag(Boolean cardInBlackListFlag) {
        this.cardInBlackListFlag = cardInBlackListFlag;
    }

    @JsonProperty("cardIsCleanFlag")
    public Boolean getCardIsCleanFlag() {
        return cardIsCleanFlag;
    }

    @JsonProperty("cardIsCleanFlag")
    public void setCardIsCleanFlag(Boolean cardIsCleanFlag) {
        this.cardIsCleanFlag = cardIsCleanFlag;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
