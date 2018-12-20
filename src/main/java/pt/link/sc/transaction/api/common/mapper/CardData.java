
package pt.link.sc.transaction.api.common.mapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardInfo",
    "contractInfos",
    "transportInfo",
    "csvTransaction"
})
public class CardData implements Serializable
{

    @JsonProperty("cardInfo")
    private CardInfo cardInfo;
    @JsonProperty("contractInfos")
    private List<ContractInfo> contractInfos = null;
    @JsonProperty("transportInfo")
    private TransportInfo transportInfo;
    @JsonProperty("csvTransaction")
    private String csvTransaction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7118135841360696563L;

    @JsonProperty("cardInfo")
    public CardInfo getCardInfo() {
        return cardInfo;
    }

    @JsonProperty("cardInfo")
    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    @JsonProperty("contractInfos")
    public List<ContractInfo> getContractInfos() {
        return contractInfos;
    }

    @JsonProperty("contractInfos")
    public void setContractInfos(List<ContractInfo> contractInfos) {
        this.contractInfos = contractInfos;
    }

    @JsonProperty("transportInfo")
    public TransportInfo getTransportInfo() {
        return transportInfo;
    }

    @JsonProperty("transportInfo")
    public void setTransportInfo(TransportInfo transportInfo) {
        this.transportInfo = transportInfo;
    }

    @JsonProperty("csvTransaction")
    public String getCsvTransaction() {
        return csvTransaction;
    }

    @JsonProperty("csvTransaction")
    public void setCsvTransaction(String csvTransaction) {
        this.csvTransaction = csvTransaction;
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
