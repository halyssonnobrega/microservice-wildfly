package pt.link.sc.transaction.api.resources.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contains a card key")
public class CardKey {

	@ApiModelProperty(value = "The description of key")
	private String keyDescription;

	@ApiModelProperty(value = "The key number")
	private Integer keyNumber;

	@ApiModelProperty(value = "The key value in hexadecimal")
	private String keyHexString;

	public String getKeyDescription() {
		return keyDescription;
	}

	public void setKeyDescription(String keyDescription) {
		this.keyDescription = keyDescription;
	}

	public String getKeyHexString() {
		return keyHexString;
	}

	public void setKeyHexString(String keyHexString) {
		this.keyHexString = keyHexString;
	}

	public Integer getKeyNumber() {
		return keyNumber;
	}

	public void setKeyNumber(Integer keyNumber) {
		this.keyNumber = keyNumber;
	}

}