package pt.link.sc.transaction.api.resources.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value = "Product")
public class Product {

    @ApiModelProperty(value = "The product id")
    @NotNull
    private String productId;

    @ApiModelProperty(value = "The product name")
    private String productName;

    @ApiModelProperty(value = "The product type")
    @NotNull
    private String productType;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType + "]";
    }

}
