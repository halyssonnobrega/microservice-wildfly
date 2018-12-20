package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VALIDATIONS", schema = "transactions")
public class ValidationEO extends AbstractAuditInfoEO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1105535356339075896L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INTEGRATION_LOG_ID")
	private IntegrationLogEO integrationLog;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALIDATION_STATE_ID")
	private ValidationStateEO validationState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALIDATION_STATE_REASON_ID")
	private ValidationStatesReasonEO validationStatesReason;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALIDATION_TYPE_ID")
	private ValidationTypeEO validationType;
	
	@Column(name = "VALIDATION_IDENTIFIER", length = 100)
	private String validationIdentifier;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALIDATION_DATE", length = 27)
	private Date validationDate;
	
	@Column(name = "GROUP_ID")
	private String groupId;
	
	@Column(name = "OBSOLETE_FIRST_ENTRY_OPER")
	private Integer obsoleteFirstEntryOper;
	
	@Column(name = "PREV_EVENT_OPER")
	private Integer prevEventOper;
	
	@Column(name = "PREV_EVENT_BINARY", length = 100)
	private String prevEventBinary;
	
	@Column(name = "EVENT_BINARY")
	private String eventBinary;
	
	@Column(name = "EVENT_SUCCESS_CODE")
	private Integer eventSuccessCode;
	
	@Column(name = "VALIDATOR_MACHINE_CODE")
	private Integer validatorMachineCode;
	
	@Column(name = "CARD_DATA_MODEL_ID")
	private Integer cardDataModelId;
	
	@Column(name = "CARD_PHYSICAL_TYPE_ID")
	private Integer cardPhysicalTypeId;
	
	@Column(name = "CARD_NUMBER")
	private Integer cardNumber;
	
	@Column(name = "CARD_SERIAL_NUMBER")
	private Integer cardSerialNumber;
	
	@Column(name = "MAC", length = 100)
	private String mac;
	
	@Column(name = "CONT_LOCATION")
	private Integer contLocation;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FIRST_DATA_TIME_ENTRANCE", length = 27)
	private Date firstDataTimeEntrance;
	
	@Column(name = "STOP")
	private Integer stop;
	
	@Column(name = "RUN_CODE")
	private Integer runCode;
	
	@Column(name = "DIRECTION")
	private Integer direction;
	
	@Column(name = "ROUTE")
	private Integer route;
	
	@Column(name = "PREV_HIST_RFU")
	private Integer prevHistRfu;
	
	@Column(name = "HIST_RFU")
	private Integer histRfu;
	
	@Column(name = "RFU")
	private Integer rfu;
	
	@Column(name = "ORIGIN", length = 100)
	private String origin;
	
	@Column(name = "DESTINATION")
	private Integer destination;
	
	@Column(name = "ENTITY_ID")
	private Integer entityId;
	
	@Column(name = "CONTRACT_POSITION")
	private Integer contractPosition;
	
	@Column(name = "TICKET_CODE")
	private Integer ticketCode;
	
	@Column(name = "TICKET_OPERATOR_CODE")
	private Integer ticketOperatorCode;
	
	@Column(name = "TICKET_RELOAD_MACHINE_CODE")
	private Integer ticketReloadMachineCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TICKET_RELOAD_DATE", length = 27)
	private Date ticketReloadDate;
	
	@Column(name = "TICKET_RELOAD_NUMBER_DAILY")
	private Integer ticketReloadNumberDaily;
	
	@Column(name = "COUNTER_READ_BINARY", length = 50)
	private String counterReadBinary;
	
	@Column(name = "COUNTER_WRITTEN_BINARY", length = 50)
	private String counterWrittenBinary;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "validation", cascade = CascadeType.ALL,  targetEntity = ValidationProfileEO.class)
	private List<ValidationProfileEO> validationProfiles;

	@Column(name = "UUID")
	private String uuid;
	
	public Long getId() {
		return this.id;
	}

	public IntegrationLogEO getIntegrationLog() {
		return integrationLog;
	}

	public void setIntegrationLog(IntegrationLogEO integrationLog) {
		this.integrationLog = integrationLog;
	}

	public ValidationStateEO getValidationState() {
		return validationState;
	}

	public void setValidationState(ValidationStateEO validationState) {
		this.validationState = validationState;
	}

	public ValidationStatesReasonEO getValidationStatesReason() {
		return validationStatesReason;
	}

	public void setValidationStatesReason(ValidationStatesReasonEO validationStatesReason) {
		this.validationStatesReason = validationStatesReason;
	}

	public ValidationTypeEO getValidationType() {
		return validationType;
	}

	public void setValidationType(ValidationTypeEO validationType) {
		this.validationType = validationType;
	}

	public String getValidationIdentifier() {
		return this.validationIdentifier;
	}

	public void setValidationIdentifier(String validationIdentifier) {
		this.validationIdentifier = validationIdentifier;
	}

	public Date getValidationDate() {
		return this.validationDate;
	}

	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getObsoleteFirstEntryOper() {
		return this.obsoleteFirstEntryOper;
	}

	public void setObsoleteFirstEntryOper(Integer obsoleteFirstEntryOper) {
		this.obsoleteFirstEntryOper = obsoleteFirstEntryOper;
	}

	public Integer getPrevEventOper() {
		return this.prevEventOper;
	}

	public void setPrevEventOper(Integer prevEventOper) {
		this.prevEventOper = prevEventOper;
	}

	public String getPrevEventBinary() {
		return this.prevEventBinary;
	}

	public void setPrevEventBinary(String prevEventBinary) {
		this.prevEventBinary = prevEventBinary;
	}

	public String getEventBinary() {
		return this.eventBinary;
	}

	public void setEventBinary(String eventBinary) {
		this.eventBinary = eventBinary;
	}

	public Integer getEventSuccessCode() {
		return this.eventSuccessCode;
	}

	public void setEventSuccessCode(Integer eventSuccessCode) {
		this.eventSuccessCode = eventSuccessCode;
	}

	public Integer getValidatorMachineCode() {
		return this.validatorMachineCode;
	}

	public void setValidatorMachineCode(Integer validatorMachineCode) {
		this.validatorMachineCode = validatorMachineCode;
	}

	public Integer getCardDataModelId() {
		return this.cardDataModelId;
	}

	public void setCardDataModelId(Integer cardDataModelId) {
		this.cardDataModelId = cardDataModelId;
	}

	public Integer getCardPhysicalTypeId() {
		return this.cardPhysicalTypeId;
	}

	public void setCardPhysicalTypeId(Integer cardPhysicalTypeId) {
		this.cardPhysicalTypeId = cardPhysicalTypeId;
	}

	public Integer getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getCardSerialNumber() {
		return this.cardSerialNumber;
	}

	public void setCardSerialNumber(Integer cardSerialNumber) {
		this.cardSerialNumber = cardSerialNumber;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Integer getContLocation() {
		return this.contLocation;
	}

	public void setContLocation(Integer contLocation) {
		this.contLocation = contLocation;
	}

	public Date getFirstDataTimeEntrance() {
		return this.firstDataTimeEntrance;
	}

	public void setFirstDataTimeEntrance(Date firstDataTimeEntrance) {
		this.firstDataTimeEntrance = firstDataTimeEntrance;
	}

	public Integer getStop() {
		return this.stop;
	}

	public void setStop(Integer stop) {
		this.stop = stop;
	}

	public Integer getRunCode() {
		return this.runCode;
	}

	public void setRunCode(Integer runCode) {
		this.runCode = runCode;
	}

	public Integer getDirection() {
		return this.direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public Integer getRoute() {
		return this.route;
	}

	public void setRoute(Integer route) {
		this.route = route;
	}

	public Integer getPrevHistRfu() {
		return this.prevHistRfu;
	}

	public void setPrevHistRfu(Integer prevHistRfu) {
		this.prevHistRfu = prevHistRfu;
	}

	public Integer getHistRfu() {
		return this.histRfu;
	}

	public void setHistRfu(Integer histRfu) {
		this.histRfu = histRfu;
	}

	public Integer getRfu() {
		return this.rfu;
	}

	public void setRfu(Integer rfu) {
		this.rfu = rfu;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getDestination() {
		return this.destination;
	}

	public void setDestination(Integer destination) {
		this.destination = destination;
	}

	public Integer getEntityId() {
		return this.entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getContractPosition() {
		return this.contractPosition;
	}

	public void setContractPosition(Integer contractPosition) {
		this.contractPosition = contractPosition;
	}

	public Integer getTicketCode() {
		return this.ticketCode;
	}

	public void setTicketCode(Integer ticketCode) {
		this.ticketCode = ticketCode;
	}

	public Integer getTicketOperatorCode() {
		return this.ticketOperatorCode;
	}

	public void setTicketOperatorCode(Integer ticketOperatorCode) {
		this.ticketOperatorCode = ticketOperatorCode;
	}

	public Integer getTicketReloadMachineCode() {
		return this.ticketReloadMachineCode;
	}

	public void setTicketReloadMachineCode(Integer ticketReloadMachineCode) {
		this.ticketReloadMachineCode = ticketReloadMachineCode;
	}

	public Date getTicketReloadDate() {
		return this.ticketReloadDate;
	}

	public void setTicketReloadDate(Date ticketReloadDate) {
		this.ticketReloadDate = ticketReloadDate;
	}

	public Integer getTicketReloadNumberDaily() {
		return this.ticketReloadNumberDaily;
	}

	public void setTicketReloadNumberDaily(Integer ticketReloadNumberDaily) {
		this.ticketReloadNumberDaily = ticketReloadNumberDaily;
	}

	public String getCounterReadBinary() {
		return this.counterReadBinary;
	}

	public void setCounterReadBinary(String counterReadBinary) {
		this.counterReadBinary = counterReadBinary;
	}

	public String getCounterWrittenBinary() {
		return this.counterWrittenBinary;
	}

	public void setCounterWrittenBinary(String counterWrittenBinary) {
		this.counterWrittenBinary = counterWrittenBinary;
	}

	public List<ValidationProfileEO> getValidationProfiles() {
		return validationProfiles;
	}

	public void setValidationProfiles(List<ValidationProfileEO> validationProfiles) {
		this.validationProfiles = validationProfiles;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
