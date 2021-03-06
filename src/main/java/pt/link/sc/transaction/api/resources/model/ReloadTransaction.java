package pt.link.sc.transaction.api.resources.model;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Represents a card transaction performed by the SCF.")
public class ReloadTransaction extends Transaction{

	@ApiModelProperty(value = "The transaction subtype. Transaction subType should be sent according to the transaction type and performed transaction subtype as provided by SCF.")
	private Integer loadingTransactionType;

	@ApiModelProperty(value = "The transaction status as sent by the SCF. \n" + "\n" + "0 - no error 1 - interrupted", allowEmptyValue = false)
	@NotNull
	private Integer loadOper;

	@ApiModelProperty(value = "tickReloDate.", allowEmptyValue = false)
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date tickReloDate;

	private Integer tickReloMachCode;

	private Integer tickReloNumbDaily;

	@ApiModelProperty(value = "ID of the record on the origin system.", allowEmptyValue = true)
	private String corrTransactionID;

	private Date corrTickReloDate;

	private Integer corrTickReloMachCode;

	private Integer corrTickReloNumbDaily;

	@ApiModelProperty(value = "The card data model.", allowEmptyValue = false)
	@NotNull
	private Integer corrCardDataModel;

	private BigInteger vinhSeriNumb;

	@ApiModelProperty(value = "The amount used on the transaction. Amount field is required for debit and credit transactions. Debit amount should be greater or equal to zero. Credit amount can be negative (undo load). Examples of values: 1CHF == 100, 1.25€ == 125, 10€ == 1000.")
	private Integer loadedQuantity;

	@ApiModelProperty(value = "The amount used on the transaction. Amount field is required for debit and credit transactions. Debit amount should be greater or equal to zero. Credit amount can be negative (undo load). Examples of values: 1CHF == 100, 1.25€ == 125, 10€ == 1000.")
	private Integer productQuantity;

	private String posId;

	private BigInteger fiscalNr;

	private String invoiceNr;

	private Integer profCompOper;

	private Integer custProf;

	private Integer custProf2;

	private Integer custProf3;

	private Integer entity;

	private BigInteger corrCardIssuer;

	private Integer corrCardNumber;

	@ApiModelProperty(value = "The card serial number in hexadecimal", allowEmptyValue = false, example = "0433458AD55197")
	private String corrCardSerialNumberHexString;

	private Integer tickOperCode;

	private Integer tickCode;

	private String loadContract;

	private Integer contractIndex;

	private String greenListCounter;

	private String previousContract;

	private Date firstDateTimeEntrance;

	private Integer corrTickOperCode;

	private Integer corrTickCode;

	private Integer price;

	private Integer corrPrice;

	private Integer paymMean;

	private String paymAccount;

	private Integer comission;

	private Integer reduction;

	private Date pricingDate;

	private String pinBlock;

	private Integer paymentPriceDecimalDigits;

	@ApiModelProperty(value = "Has sub machine code.", example = "0")
	private Integer hasSubMachineCode;
	
    @ApiModelProperty(value = "The location description")
    private String locationDescription;

	@ApiModelProperty(value = "CSV generated by the scf", allowEmptyValue = false)
	@NotNull
	private String csv;
	

	public Integer getLoadingTransactionType() {
		return loadingTransactionType;
	}

	public void setLoadingTransactionType(Integer loadingTransactionType) {
		this.loadingTransactionType = loadingTransactionType;
	}
	
	public Integer getLoadOper() {
		return loadOper;
	}

	public void setLoadOper(Integer loadOper) {
		this.loadOper = loadOper;
	}

	public Date getTickReloDate() {
		return tickReloDate;
	}

	public void setTickReloDate(Date tickReloDate) {
		this.tickReloDate = tickReloDate;
	}

	public Integer getTickReloMachCode() {
		return tickReloMachCode;
	}

	public void setTickReloMachCode(Integer tickReloMachCode) {
		this.tickReloMachCode = tickReloMachCode;
	}

	public Integer getTickReloNumbDaily() {
		return tickReloNumbDaily;
	}

	public void setTickReloNumbDaily(Integer tickReloNumbDaily) {
		this.tickReloNumbDaily = tickReloNumbDaily;
	}

	public String getCorrTransactionID() {
		return corrTransactionID;
	}

	public void setCorrTransactionID(String corrTransactionID) {
		this.corrTransactionID = corrTransactionID;
	}

	public Date getCorrTickReloDate() {
		return corrTickReloDate;
	}

	public void setCorrTickReloDate(Date corrTickReloDate) {
		this.corrTickReloDate = corrTickReloDate;
	}

	public Integer getCorrTickReloMachCode() {
		return corrTickReloMachCode;
	}

	public void setCorrTickReloMachCode(Integer corrTickReloMachCode) {
		this.corrTickReloMachCode = corrTickReloMachCode;
	}

	public Integer getCorrTickReloNumbDaily() {
		return corrTickReloNumbDaily;
	}

	public void setCorrTickReloNumbDaily(Integer corrTickReloNumbDaily) {
		this.corrTickReloNumbDaily = corrTickReloNumbDaily;
	}

	public Integer getCorrCardDataModel() {
		return corrCardDataModel;
	}

	public void setCorrCardDataModel(Integer corrCardDataModel) {
		this.corrCardDataModel = corrCardDataModel;
	}

	public BigInteger getVinhSeriNumb() {
		return vinhSeriNumb;
	}

	public void setVinhSeriNumb(BigInteger vinhSeriNumb) {
		this.vinhSeriNumb = vinhSeriNumb;
	}

	public Integer getLoadedQuantity() {
		return loadedQuantity;
	}

	public void setLoadedQuantity(Integer loadedQuantity) {
		this.loadedQuantity = loadedQuantity;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public BigInteger getFiscalNr() {
		return fiscalNr;
	}

	public void setFiscalNr(BigInteger fiscalNr) {
		this.fiscalNr = fiscalNr;
	}

	public String getInvoiceNr() {
		return invoiceNr;
	}

	public void setInvoiceNr(String invoiceNr) {
		this.invoiceNr = invoiceNr;
	}

	public Integer getProfCompOper() {
		return profCompOper;
	}

	public void setProfCompOper(Integer profCompOper) {
		this.profCompOper = profCompOper;
	}

	public Integer getCustProf() {
		return custProf;
	}

	public void setCustProf(Integer custProf) {
		this.custProf = custProf;
	}

	public Integer getCustProf2() {
		return custProf2;
	}

	public void setCustProf2(Integer custProf2) {
		this.custProf2 = custProf2;
	}

	public Integer getCustProf3() {
		return custProf3;
	}

	public void setCustProf3(Integer custProf3) {
		this.custProf3 = custProf3;
	}

	public Integer getEntity() {
		return entity;
	}

	public void setEntity(Integer entity) {
		this.entity = entity;
	}

	public BigInteger getCorrCardIssuer() {
		return corrCardIssuer;
	}

	public void setCorrCardIssuer(BigInteger corrCardIssuer) {
		this.corrCardIssuer = corrCardIssuer;
	}

	public Integer getCorrCardNumber() {
		return corrCardNumber;
	}

	public void setCorrCardNumber(Integer corrCardNumber) {
		this.corrCardNumber = corrCardNumber;
	}

	public String getCorrCardSerialNumberHexString() {
		return corrCardSerialNumberHexString;
	}

	public void setCorrCardSerialNumberHexString(String corrCardSerialNumberHexString) {
		this.corrCardSerialNumberHexString = corrCardSerialNumberHexString;
	}

	public Integer getTickOperCode() {
		return tickOperCode;
	}

	public void setTickOperCode(Integer tickOperCode) {
		this.tickOperCode = tickOperCode;
	}

	public Integer getTickCode() {
		return tickCode;
	}

	public void setTickCode(Integer tickCode) {
		this.tickCode = tickCode;
	}

	public String getLoadContract() {
		return loadContract;
	}

	public void setLoadContract(String loadContract) {
		this.loadContract = loadContract;
	}

	public Integer getContractIndex() {
		return contractIndex;
	}

	public void setContractIndex(Integer contractIndex) {
		this.contractIndex = contractIndex;
	}

	public String getGreenListCounter() {
		return greenListCounter;
	}

	public void setGreenListCounter(String greenListCounter) {
		this.greenListCounter = greenListCounter;
	}

	public String getPreviousContract() {
		return previousContract;
	}

	public void setPreviousContract(String previousContract) {
		this.previousContract = previousContract;
	}

	public Date getFirstDateTimeEntrance() {
		return firstDateTimeEntrance;
	}

	public void setFirstDateTimeEntrance(Date firstDateTimeEntrance) {
		this.firstDateTimeEntrance = firstDateTimeEntrance;
	}

	public Integer getCorrTickOperCode() {
		return corrTickOperCode;
	}

	public void setCorrTickOperCode(Integer corrTickOperCode) {
		this.corrTickOperCode = corrTickOperCode;
	}

	public Integer getCorrTickCode() {
		return corrTickCode;
	}

	public void setCorrTickCode(Integer corrTickCode) {
		this.corrTickCode = corrTickCode;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCorrPrice() {
		return corrPrice;
	}

	public void setCorrPrice(Integer corrPrice) {
		this.corrPrice = corrPrice;
	}

	public Integer getPaymMean() {
		return paymMean;
	}

	public void setPaymMean(Integer paymMean) {
		this.paymMean = paymMean;
	}

	public String getPaymAccount() {
		return paymAccount;
	}

	public void setPaymAccount(String paymAccount) {
		this.paymAccount = paymAccount;
	}

	public Integer getComission() {
		return comission;
	}

	public void setComission(Integer comission) {
		this.comission = comission;
	}

	public Integer getReduction() {
		return reduction;
	}

	public void setReduction(Integer reduction) {
		this.reduction = reduction;
	}

	public Date getPricingDate() {
		return pricingDate;
	}

	public void setPricingDate(Date pricingDate) {
		this.pricingDate = pricingDate;
	}

	public String getPinBlock() {
		return pinBlock;
	}

	public void setPinBlock(String pinBlock) {
		this.pinBlock = pinBlock;
	}

	public Integer getPaymentPriceDecimalDigits() {
		return paymentPriceDecimalDigits;
	}

	public void setPaymentPriceDecimalDigits(Integer paymentPriceDecimalDigits) {
		this.paymentPriceDecimalDigits = paymentPriceDecimalDigits;
	}

	public Integer getHasSubMachineCode() {
		return hasSubMachineCode;
	}

	public void setHasSubMachineCode(Integer hasSubMachineCode) {
		this.hasSubMachineCode = hasSubMachineCode;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	@Override
	public String toString() {
		return "Reload Transaction [transactionType=" + super.getTransactionType() + 
						  ", loadingTransactionType=" + loadingTransactionType +
						  ", transactionVersion=" + super.getTransactionVersion() + 
						  ", transactionId=" + super.getTransactionId() + 
						  ", groupId=" + super.getGroupId() + 
						  ", transactionDate=" + super.getTransactionDate() + 
						  ", loadOper=" + loadOper + 
						  ", tickReloDate=" + tickReloDate + 
						  ", tickReloMachCode=" + tickReloMachCode + 
						  ", tickReloNumbDaily=" + tickReloNumbDaily + 
						  ", corrTransactionID=" + corrTransactionID + 
						  ", corrTickReloDate=" + corrTickReloDate + 
						  ", corrTickReloMachCode=" + corrTickReloMachCode + 
						  ", corrTickReloNumbDaily=" + corrTickReloNumbDaily + 
						  ", corrCardDataModel=" + corrCardDataModel + 
						  ", vinhSeriNumb=" + vinhSeriNumb + 
						  ", loadedQuantity=" + loadedQuantity + 
						  ", productQuantity=" + productQuantity + 
						  ", posId=" + posId + 
						  ", fiscalNr=" + fiscalNr + 
						  ", invoiceNr=" + invoiceNr + 
						  ", cardDataModel=" + super.getCardDataModel() + 
						  ", cardPhysicalType=" + super.getCardPhysicalType() + 
						  ", cardIssuer=" + super.getCardIssuer() + 
						  ", cardNumb=" + super.getCardNumb() + 
						  ", cardSerialNumberHexString=" + super.getCardSerialNumberHexString() + 
						  ", cardCalypsoChipRef=" + super.getCardCalypsoChipRef() + 
						  ", cardCalypsoApplType=" + super.getCardCalypsoApplType() + 
						  ", cardCalypsoApplSubType=" + super.getCardCalypsoApplSubType() + 
						  ", cardCalypsoApplIssu=" + super.getCardCalypsoApplIssu() + 
						  ", profCompOper=" + profCompOper + 
						  ", custProf=" + custProf + 
						  ", custProf2=" + custProf2 + 
						  ", custProf3=" + custProf3 + 
						  ", entity=" + entity + 
						  ", corrCardIssuer=" + corrCardIssuer + 
						  ", corrCardNumber=" + corrCardNumber + 
						  ", corrCardSerialNumberHexString=" + corrCardSerialNumberHexString + 
						  ", tickOperCode=" + tickOperCode + 
						  ", tickCode=" + tickCode + 
						  ", loadContract=" + loadContract + 
						  ", contractIndex=" + contractIndex + 
						  ", greenListCounter=" + greenListCounter + 
						  ", previousContract=" + previousContract + 
						  ", firstDateTimeEntrance=" + firstDateTimeEntrance + 
						  ", corrTickOperCode=" + corrTickOperCode + 
						  ", corrTickCode=" + corrTickCode + 
						  ", price=" + price + 
						  ", corrPrice=" + corrPrice + 
						  ", paymMean=" + paymMean + 
						  ", paymAccount=" + paymAccount + 
						  ", comission=" + comission + 
						  ", reduction=" + reduction + 
						  ", pricingDate=" + pricingDate + 
						  ", pinBlock=" + pinBlock + 
						  ", mac=" + super.getMac() + 
						  ", paymentPriceDecimalDigits=" + paymentPriceDecimalDigits + 
						  ", hasSubMachineCode=" + hasSubMachineCode + 
						  ", prof1Code=" + super.getProf1Code() + 
						  ", prof1ExpDate=" + super.getProf1ExpDate() + 
						  ", prof2Code=" + super.getProf2Code() + 
						  ", prof2ExpDate=" + super.getProf2ExpDate() + 
						  ", prof3Code=" + super.getProf3Code() + 
						  ", prof3ExpDate=" + super.getProf3ExpDate() + 
						  ", locationDescription=" + locationDescription + 
						  ", csv=" + csv + "]";				
	}
}