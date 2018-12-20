package pt.link.sc.transaction.api.resources.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contains the card keys necessary to perform the transaction on the card")
public class CardKeyResponse {

	@ApiModelProperty(value = "A list of keys to perform the requested transaction")
	private List<CardKey> cardKeys;

	public List<CardKey> getCardKeys() {
		return cardKeys;
	}

	public void setCardKeys(List<CardKey> cardKeys) {
		this.cardKeys = cardKeys;
	}
}
