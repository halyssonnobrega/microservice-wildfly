
package pt.link.sc.transaction.api.common.mapper;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "issuingDateTime",
    "expirationDate",
    "currencyCode"
})
public class TransportInfo implements Serializable
{

    @JsonProperty("issuingDateTime")
    private String issuingDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty("expirationDate")
    private Date expirationDate;
    @JsonProperty("currencyCode")
    private Long currencyCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4088428254942522773L;

    @JsonProperty("issuingDateTime")
    public String getIssuingDateTime() {
        return issuingDateTime;
    }

    @JsonProperty("issuingDateTime")
    public void setIssuingDateTime(String issuingDateTime) {
        this.issuingDateTime = issuingDateTime;
    }

    @JsonProperty("expirationDate")
    public Date getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty("expirationDate")
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonProperty("currencyCode")
    public Long getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(Long currencyCode) {
        this.currencyCode = currencyCode;
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
