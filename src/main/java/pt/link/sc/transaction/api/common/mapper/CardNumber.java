
package pt.link.sc.transaction.api.common.mapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appIssuer",
    "cardNumber"
})
public class CardNumber implements Serializable
{

    @JsonProperty("appIssuer")
    private Long appIssuer;
    @JsonProperty("cardNumber")
    private Long cardNumber;

    @JsonProperty("appCardNumber")
    private Long appCardNumber;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3502617394610495703L;

    @JsonProperty("appIssuer")
    public Long getAppIssuer() {
        return appIssuer;
    }

    @JsonProperty("appIssuer")
    public void setAppIssuer(Long appIssuer) {
        this.appIssuer = appIssuer;
    }

    @JsonProperty("cardNumber")
    public Long getCardNumber() {
        return cardNumber;
    }

    //FIXME HAMMER TIME - should only be one cardNumber
    @JsonProperty("appCardNumber")
    public void setAppCardNumber(Long appCardNumber) {
        this.appCardNumber = appCardNumber;
    }

    @JsonProperty("appCardNumber")
    public Long getAppCardNumber() {
        return appCardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
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
