
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
    "highPart",
    "lowPart"
})
public class CardSerialNumber implements Serializable
{

    @JsonProperty("highPart")
    private Long highPart;
    @JsonProperty("lowPart")
    private Long lowPart;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9056602608129286242L;

    @JsonProperty("highPart")
    public Long getHighPart() {
        return highPart;
    }

    @JsonProperty("highPart")
    public void setHighPart(Long highPart) {
        this.highPart = highPart;
    }

    @JsonProperty("lowPart")
    public Long getLowPart() {
        return lowPart;
    }

    @JsonProperty("lowPart")
    public void setLowPart(Long lowPart) {
        this.lowPart = lowPart;
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
