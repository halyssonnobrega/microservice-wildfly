package pt.link.sc.transaction.api.resources.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Register transactions response")
public class RegisterTransactionsResponse {

    @ApiModelProperty(value = "The uuid that identifies the transactions registration. This can be used by the 'transactionStatus' to check for transaction errors.", readOnly = true)
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}