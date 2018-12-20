package pt.link.sc.transaction.api.resources.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "A performed authorized operation")
public class AuthorizedCardOperation {
    @ApiModelProperty(value = "The uuid of the authorized operation", allowEmptyValue = false)
    @NotNull
    private String authorizationUuid;

    @ApiModelProperty(value = "The date of the operation", allowEmptyValue = false)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date performedOnDate;

    @ApiModelProperty(value = "Resulting csv transaction of the operation")
    @Valid
    private CsvTransaction csvTransaction;

    public String getAuthorizationUuid() {
        return authorizationUuid;
    }

    public void setAuthorizationUuid(String authorizationUuid) {
        this.authorizationUuid = authorizationUuid;
    }

    public Date getPerformedOnDate() {
        return performedOnDate;
    }

    public void setPerformedOnDate(Date performedOnDate) {
        this.performedOnDate = performedOnDate;
    }

    public CsvTransaction getCsvTransaction() {
        return csvTransaction;
    }

    public void setCsvTransaction(CsvTransaction csvTransaction) {
        this.csvTransaction = csvTransaction;
    }

}