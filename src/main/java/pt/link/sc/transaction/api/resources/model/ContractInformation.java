package pt.link.sc.transaction.api.resources.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contains the contract information")
public class ContractInformation {
	@ApiModelProperty(value = "The card contract pointer")
	private Integer contractPointer;

	@ApiModelProperty(value = "The consolidated card contract balance")
	private Long consolidatedContractBalance;

	@ApiModelProperty(value = "The card contract balance")
	private Long contractBalance;

	public Integer getContractPointer() {
		return contractPointer;
	}

	public void setContractPointer(Integer contractPointer) {
		this.contractPointer = contractPointer;
	}

	public Long getConsolidatedContractBalance() {
		return consolidatedContractBalance;
	}

	public void setConsolidatedContractBalance(Long consolidatedContractBalance) {
		this.consolidatedContractBalance = consolidatedContractBalance;
	}

	public Long getContractBalance() {
		return contractBalance;
	}

	public void setContractBalance(Long contractBalance) {
		this.contractBalance = contractBalance;
	}

	@Override
	public String toString() {
		return "ContractInformation [contractPointer=" + contractPointer + ", consolidatedContractBalance=" + consolidatedContractBalance + ", contractBalance=" + contractBalance + "]";
	}

}