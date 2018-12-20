package pt.link.sc.transaction.api.resources.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contains the card information")
public class CardInformation {

	@ApiModelProperty(value = "The card id", allowEmptyValue = false)
	private CardId cardId;

	@ApiModelProperty(value = "The list of card contracts")
	private List<ContractInformation> contractInformation;

	@ApiModelProperty(value = "The card currency code")
	private String currencyCode;

	@ApiModelProperty(value = "The card activation date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date activationDate;

	@ApiModelProperty(value = "The card expiration date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date expirationDate;

	@ApiModelProperty(value = "The card status")
	private CardStatusEnum cardStatus;

	public List<ContractInformation> getContractInformation() {
		return contractInformation;
	}

	public void setContractInformation(List<ContractInformation> contractInformation) {
		this.contractInformation = contractInformation;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public CardStatusEnum getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(CardStatusEnum cardStatus) {
		this.cardStatus = cardStatus;
	}

	public CardId getCardId() {
		return cardId;
	}

	public void setCardId(CardId cardId) {
		this.cardId = cardId;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "CardInformation [cardId=" + cardId + ", contractInformation=" + contractInformation + ", currencyCode=" + currencyCode + ", activationDate=" + activationDate + ", cardStatus=" + cardStatus + "]";
	}

}