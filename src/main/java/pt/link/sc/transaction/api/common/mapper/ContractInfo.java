
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
    "contractNumber",
    "productId",
    "displayInfos"
})
public class ContractInfo implements Serializable
{

    @JsonProperty("contractNumber")
    private Long contractNumber;
    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("displayInfos")
    private List<DisplayInfo> displayInfos = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1767797053378250809L;

    @JsonProperty("contractNumber")
    public Long getContractNumber() {
        return contractNumber;
    }

    @JsonProperty("contractNumber")
    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    @JsonProperty("productId")
    public Long getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @JsonProperty("displayInfos")
    public List<DisplayInfo> getDisplayInfos() {
        return displayInfos;
    }

    @JsonProperty("displayInfos")
    public void setDisplayInfos(List<DisplayInfo> displayInfos) {
        this.displayInfos = displayInfos;
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
