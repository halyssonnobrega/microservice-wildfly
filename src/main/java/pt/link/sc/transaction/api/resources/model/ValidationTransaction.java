package pt.link.sc.transaction.api.resources.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The validation transaction CSV is generated with each validation transaction on a card.This includes: Contract Validation and Profile Validation")
public class ValidationTransaction extends Transaction{

	@ApiModelProperty(value = "The transaction status as sent by the SCF. \n" + "\n" + "0 - no error 1 - interrupted", allowEmptyValue = false)
	@NotNull
	private Integer eventOper;

	private Integer eventSuccessCode;
	
	private Integer eventType;
	
	private Integer eventMachineCode;
	
	private Date eventFirstDatetimeEntrance;
	
	private Integer eventContLocation;
	
	private Integer eventStopIndex;
	
	private Integer eventStopSubIndex;
	
	private Integer eventRunCode;
	
	private Integer eventRouteCode;
	
	private String eventBinary;

	private String validationBinary;

	private Integer originIndexCode;

	private Integer originSubIndexCode;

	private Integer destinationIndexcode;

	private Integer destinationSubIndexcode;
	
    @ApiModelProperty(value = "The location description")
    private String locationDescription;

	@ApiModelProperty(value = "CSV generated by the scf", allowEmptyValue = false)
	@NotNull
	private String csv;

	public Integer getEventOper() {
		return eventOper;
	}

	public void setEventOper(Integer eventOper) {
		this.eventOper = eventOper;
	}
	
	public Integer getEventSuccessCode() {
		return eventSuccessCode;
	}

	public void setEventSuccessCode(Integer eventSuccessCode) {
		this.eventSuccessCode = eventSuccessCode;
	}

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public Integer getEventMachineCode() {
		return eventMachineCode;
	}

	public void setEventMachineCode(Integer eventMachineCode) {
		this.eventMachineCode = eventMachineCode;
	}

	public Date getEventFirstDatetimeEntrance() {
		return eventFirstDatetimeEntrance;
	}

	public void setEventFirstDatetimeEntrance(Date eventFirstDatetimeEntrance) {
		this.eventFirstDatetimeEntrance = eventFirstDatetimeEntrance;
	}

	public Integer getEventContLocation() {
		return eventContLocation;
	}

	public void setEventContLocation(Integer eventContLocation) {
		this.eventContLocation = eventContLocation;
	}

	public Integer getEventStopIndex() {
		return eventStopIndex;
	}

	public void setEventStopIndex(Integer eventStopIndex) {
		this.eventStopIndex = eventStopIndex;
	}

	public Integer getEventStopSubIndex() {
		return eventStopSubIndex;
	}

	public void setEventStopSubIndex(Integer eventStopSubIndex) {
		this.eventStopSubIndex = eventStopSubIndex;
	}

	public Integer getEventRunCode() {
		return eventRunCode;
	}

	public void setEventRunCode(Integer eventRunCode) {
		this.eventRunCode = eventRunCode;
	}

	public Integer getEventRouteCode() {
		return eventRouteCode;
	}

	public void setEventRouteCode(Integer eventRouteCode) {
		this.eventRouteCode = eventRouteCode;
	}

	public String getEventBinary() {
		return eventBinary;
	}

	public void setEventBinary(String eventBinary) {
		this.eventBinary = eventBinary;
	}

	public String getValidationBinary() {
		return validationBinary;
	}

	public void setValidationBinary(String validationBinary) {
		this.validationBinary = validationBinary;
	}

	public Integer getOriginIndexCode() {
		return originIndexCode;
	}

	public void setOriginIndexCode(Integer originIndexCode) {
		this.originIndexCode = originIndexCode;
	}

	public Integer getOriginSubIndexCode() {
		return originSubIndexCode;
	}

	public void setOriginSubIndexCode(Integer originSubIndexCode) {
		this.originSubIndexCode = originSubIndexCode;
	}

	public Integer getDestinationIndexcode() {
		return destinationIndexcode;
	}

	public void setDestinationIndexcode(Integer destinationIndexcode) {
		this.destinationIndexcode = destinationIndexcode;
	}

	public Integer getDestinationSubIndexcode() {
		return destinationSubIndexcode;
	}

	public void setDestinationSubIndexcode(Integer destinationSubIndexcode) {
		this.destinationSubIndexcode = destinationSubIndexcode;
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
						  ", transactionVersion=" + super.getTransactionVersion() + 
						  ", transactionId=" + super.getTransactionId() + 
						  ", groupId=" + super.getGroupId() + 
						  ", transactionDate=" + super.getTransactionDate() + 
						  ", eventOper=" + eventOper +
						  ", eventSuccessCode=" + eventSuccessCode +
						  ", eventType=" + eventType +
						  ", eventMachineCode=" + eventMachineCode +
						  ", eventFirstDatetimeEntrance=" + eventFirstDatetimeEntrance +
						  ", eventContLocation=" + eventContLocation +
						  ", eventStopIndex=" + eventStopIndex +
						  ", eventStopSubindex=" + eventStopSubIndex +
						  ", eventRunCode=" + eventRunCode +
						  ", eventRouteCode=" + eventRouteCode +
						  ", cardDataModel=" + super.getCardDataModel() + 
						  ", cardPhysicalType=" + super.getCardPhysicalType() + 
						  ", cardIssuer=" + super.getCardIssuer() + 
						  ", cardNumb=" + super.getCardNumb() + 
						  ", cardSerialNumberHexString=" + super.getCardSerialNumberHexString() + 
						  ", cardCalypsoChipRef=" + super.getCardCalypsoChipRef() + 
						  ", cardCalypsoApplType=" + super.getCardCalypsoApplType() + 
						  ", cardCalypsoApplSubType=" + super.getCardCalypsoApplSubType() + 
						  ", cardCalypsoApplIssu=" + super.getCardCalypsoApplIssu() + 
						  ", eventBinary=" + eventBinary +
						  ", validationBinary=" + validationBinary +
						  ", originIndexCode=" + originIndexCode +
						  ", originSubIndexCode=" + originSubIndexCode +
						  ", destinationIndexCode=" + destinationIndexcode +
						  ", destinationSubIndexCode=" + destinationSubIndexcode +
						  ", mac=" + super.getMac() + 
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