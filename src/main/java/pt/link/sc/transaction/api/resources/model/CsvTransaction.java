package pt.link.sc.transaction.api.resources.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "A csv validation and the channel type where it was performed.")
public class CsvTransaction {

    @ApiModelProperty(value = "The csv line representing a card transaction", allowEmptyValue = false)
    @NotNull
    private String csv;

    @ApiModelProperty(value = "ID of the record on the origin system.", allowEmptyValue = true)
    private String correlationId;

    @ApiModelProperty(value = "The description of the location where the transaction occurred", allowEmptyValue = true)
    private String locationDescription;

    public String getCsv() {
        return csv;
    }

    public void setCsv(String csv) {
        this.csv = csv;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

}
