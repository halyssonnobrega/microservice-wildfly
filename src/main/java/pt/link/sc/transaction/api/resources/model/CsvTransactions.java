package pt.link.sc.transaction.api.resources.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(value = "Contains a group of csv transactions.")
public class CsvTransactions {

    @ApiModelProperty(value = "A list of card transactions.", allowEmptyValue = false)
    @NotNull
    @Valid
    private List<CsvTransaction> csvTransactions;

    @ApiModelProperty(value = "The channel point identifier.")
    private String channelPointId;

    @ApiModelProperty(value = "The channel point description.")
    private String channelPointDescription;


    @ApiModelProperty(value = "The correlation id between the system that submitted the transaction and the backoffice", allowEmptyValue = true)
    private String correlationId;

    public List<CsvTransaction> getCsvTransactions() {
        return csvTransactions;
    }

    public void setCsvTransactions(List<CsvTransaction> csvTransactions) {
        this.csvTransactions = csvTransactions;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
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
}