package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigInteger;
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
@Table(name = "TRANSACTIONS", schema = "transactions")
public class TransactionEO extends AbstractAuditInfoEO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2175557104105270156L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTHORIZATION_ID")
	private AuthorizationEO authorization;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTION_STATE_ID")
	private TransactionStateEO transactionState;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTION_STATE_REASON_ID")
	private TransactionStatesReasonEO transactionStatesReason;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTION_TYPE_ID")
	private TransactionTypeEO transactionType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INTEGRATION_LOG_ID")
	private IntegrationLogEO integrationLog;
	
	@Column(name = "GROUP_ID")
	private String groupId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TRANSACTION_DATE", length = 27)
	private Date transactionDate;
	
	@Column(name = "LOAD_OPER")
	private Integer loadOper;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TICKET_RELOAD_DATE", length = 27)
	private Date ticketReloadDate;
	
	@Column(name = "TICKET_RELOAD_MACHINE_CODE")
	private Integer ticketReloadMachineCode;
	
	@Column(name = "TICKET_RELOAD_NUMBER_DAILY")
	private Integer ticketReloadNumberDaily;
	
	@Column(name = "CORR_TRANSACTION_IDENTIFIER")
	private String corrTransactionIdentifier;
	
	@Column(name = "CORR_TICK_RELOAD_MACHINE_CODE")
	private Integer corrTickReloadMachineCode;
	
	@Column(name = "CORR_TICK_RELOAD_NUMBER_DAILY")
	private Integer corrTickReloadNumberDaily;
	
	@Column(name = "CORR_CARD_DATA_MODEL_ID")
	private Integer corrCardDataModelId;
	
	@Column(name = "VINH_SERI_NR")
	private BigInteger vinhSeriNr;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "POS_ID")
	private String posId;
	
	@Column(name = "FISCAL_NUMBER")
	private BigInteger fiscalNumber;
	
	@Column(name = "INVOICE_NUMBER")
	private String invoiceNumber;
	
	@Column(name = "CARD_DATA_MODEL_ID")
	private Integer cardDataModelId;
	
	@Column(name = "CARD_PHYSICAL_TYPE_ID")
	private Integer cardPhysicalTypeId;
	
	@Column(name = "NETWORK_CODE")
	private Integer networkCode;
	
	@Column(name = "CARD_NUMBER")
	private BigInteger cardNumber;
	
	@Column(name = "CARD_SERIAL_NUMBER")
	private BigInteger cardSerialNumber;
	
	@Column(name = "ENTITY_ID")
	private Integer entityId;
	
	@Column(name = "CORR_CARD_NUMBER")
	private Integer corrCardNumber;
	
	@Column(name = "CORR_CARD_SERIAL_NUMBER")
	private BigInteger corrCardSerialNumber;
	
	@Column(name = "TICKET_OPERATOR_CODE")
	private Integer ticketOperatorCode;
	
	@Column(name = "TICKET_CODE")
	private Integer ticketCode;
	
	@Column(name = "CONTRACT_BINARY")
	private String contractBinary;
	
	@Column(name = "CONTRACT_POSITION")
	private Integer contractPosition;
	
	@Column(name = "PREVIOUS_CONTRACT_BINARY")
	private String previousContractBinary;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FIRST_DATE_TIME_ENTRANCE", length = 27)
	private Date firstDateTimeEntrance;
	
	@Column(name = "CORR_TICK_OPER_CODE")
	private Integer corrTickOperCode;
	
	@Column(name = "CORR_TICK_CODE")
	private Integer corrTickCode;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@Column(name = "CORR_PRICE")
	private Integer corrPrice;
	
	@Column(name = "PAYMENT_MEAN")
	private Integer paymentMean;
	
	@Column(name = "COMISSION")
	private Integer comission;
	
	@Column(name = "PIN_BLOCK")
	private String pinBlock;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.ALL,  targetEntity = TransactionProfileEO.class)
	private List<TransactionProfileEO> transactionProfiles;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHANNEL_POINT_ID")
	private ChannelPointEO channelPoint;

	@Column(name = "UUID")
	private String uuid;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OFFLINE_CARD_OPERATION_ID")
    private OfflineCardOperationEO offlineCardOperation;
	
	public Long getId() {
		return this.id;
	}

	public AuthorizationEO getAuthorization() {
		return authorization;
	}

	public void setAuthorization(AuthorizationEO authorization) {
		this.authorization = authorization;
	}

	public TransactionStateEO getTransactionState() {
		return transactionState;
	}

	public void setTransactionState(TransactionStateEO transactionState) {
		this.transactionState = transactionState;
	}

	public TransactionStatesReasonEO getTransactionStatesReason() {
		return transactionStatesReason;
	}

	public void setTransactionStatesReason(TransactionStatesReasonEO transactionStatesReason) {
		this.transactionStatesReason = transactionStatesReason;
	}

	public TransactionTypeEO getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypeEO transactionType) {
		this.transactionType = transactionType;
	}

	public IntegrationLogEO getIntegrationLog() {
		return integrationLog;
	}

	public void setIntegrationLog(IntegrationLogEO integrationLog) {
		this.integrationLog = integrationLog;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getLoadOper() {
		return loadOper;
	}

	public void setLoadOper(Integer loadOper) {
		this.loadOper = loadOper;
	}

	public Date getTicketReloadDate() {
		return this.ticketReloadDate;
	}

	public void setTicketReloadDate(Date ticketReloadDate) {
		this.ticketReloadDate = ticketReloadDate;
	}

	public Integer getTicketReloadMachineCode() {
		return this.ticketReloadMachineCode;
	}

	public void setTicketReloadMachineCode(Integer ticketReloadMachineCode) {
		this.ticketReloadMachineCode = ticketReloadMachineCode;
	}

	public Integer getTicketReloadNumberDaily() {
		return this.ticketReloadNumberDaily;
	}

	public void setTicketReloadNumberDaily(Integer ticketReloadNumberDaily) {
		this.ticketReloadNumberDaily = ticketReloadNumberDaily;
	}

	public String getCorrTransactionIdentifier() {
		return this.corrTransactionIdentifier;
	}

	public void setCorrTransactionIdentifier(String corrTransactionIdentifier) {
		this.corrTransactionIdentifier = corrTransactionIdentifier;
	}

	public Integer getCorrTickReloadMachineCode() {
		return this.corrTickReloadMachineCode;
	}

	public void setCorrTickReloadMachineCode(Integer corrTickReloadMachineCode) {
		this.corrTickReloadMachineCode = corrTickReloadMachineCode;
	}

	public Integer getCorrTickReloadNumberDaily() {
		return this.corrTickReloadNumberDaily;
	}

	public void setCorrTickReloadNumberDaily(Integer corrTickReloadNumberDaily) {
		this.corrTickReloadNumberDaily = corrTickReloadNumberDaily;
	}

	public Integer getCorrCardDataModelId() {
		return this.corrCardDataModelId;
	}

	public void setCorrCardDataModelId(Integer corrCardDataModelId) {
		this.corrCardDataModelId = corrCardDataModelId;
	}

	public BigInteger getVinhSeriNr() {
		return this.vinhSeriNr;
	}

	public void setVinhSeriNr(BigInteger vinhSeriNr) {
		this.vinhSeriNr = vinhSeriNr;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPosId() {
		return this.posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public BigInteger getFiscalNumber() {
		return this.fiscalNumber;
	}

	public void setFiscalNumber(BigInteger fiscalNumber) {
		this.fiscalNumber = fiscalNumber;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public Integer getNetworkCode() {
		return this.networkCode;
	}

	public void setNetworkCode(Integer networkCode) {
		this.networkCode = networkCode;
	}

	public BigInteger getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}

	public BigInteger getCardSerialNumber() {
		return this.cardSerialNumber;
	}

	public void setCardSerialNumber(BigInteger cardSerialNumber) {
		this.cardSerialNumber = cardSerialNumber;
	}

	public Integer getEntityId() {
		return this.entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getCorrCardNumber() {
		return this.corrCardNumber;
	}

	public void setCorrCardNumber(Integer corrCardNumber) {
		this.corrCardNumber = corrCardNumber;
	}

	public BigInteger getCorrCardSerialNumber() {
		return this.corrCardSerialNumber;
	}

	public void setCorrCardSerialNumber(BigInteger corrCardSerialNumber) {
		this.corrCardSerialNumber = corrCardSerialNumber;
	}

	public Integer getTicketOperatorCode() {
		return this.ticketOperatorCode;
	}

	public void setTicketOperatorCode(Integer ticketOperatorCode) {
		this.ticketOperatorCode = ticketOperatorCode;
	}

	public Integer getTicketCode() {
		return this.ticketCode;
	}

	public void setTicketCode(Integer ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getContractBinary() {
		return this.contractBinary;
	}

	public void setContractBinary(String contractBinary) {
		this.contractBinary = contractBinary;
	}

	public Integer getContractPosition() {
		return this.contractPosition;
	}

	public void setContractPosition(Integer contractPosition) {
		this.contractPosition = contractPosition;
	}

	public String getPreviousContractBinary() {
		return this.previousContractBinary;
	}

	public void setPreviousContractBinary(String previousContractBinary) {
		this.previousContractBinary = previousContractBinary;
	}

	public Date getFirstDateTimeEntrance() {
		return this.firstDateTimeEntrance;
	}

	public void setFirstDateTimeEntrance(Date firstDateTimeEntrance) {
		this.firstDateTimeEntrance = firstDateTimeEntrance;
	}

	public Integer getCorrTickOperCode() {
		return this.corrTickOperCode;
	}

	public void setCorrTickOperCode(Integer corrTickOperCode) {
		this.corrTickOperCode = corrTickOperCode;
	}

	public Integer getCorrTickCode() {
		return this.corrTickCode;
	}

	public void setCorrTickCode(Integer corrTickCode) {
		this.corrTickCode = corrTickCode;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCorrPrice() {
		return this.corrPrice;
	}

	public void setCorrPrice(Integer corrPrice) {
		this.corrPrice = corrPrice;
	}

	public Integer getPaymentMean() {
		return this.paymentMean;
	}

	public void setPaymentMean(Integer paymentMean) {
		this.paymentMean = paymentMean;
	}

	public Integer getComission() {
		return this.comission;
	}

	public void setComission(Integer comission) {
		this.comission = comission;
	}

	public String getPinBlock() {
		return this.pinBlock;
	}

	public void setPinBlock(String pinBlock) {
		this.pinBlock = pinBlock;
	}

	public List<TransactionProfileEO> getTransactionProfiles() {
		return transactionProfiles;
	}

	public void setTransactionProfiles(List<TransactionProfileEO> transactionProfiles) {
		this.transactionProfiles = transactionProfiles;
	}

	public ChannelPointEO getChannelPoint() {
		return channelPoint;
	}

	public void setChannelPoint(ChannelPointEO channelPoint) {
		this.channelPoint = channelPoint;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public OfflineCardOperationEO getOfflineCardOperation() {
		return offlineCardOperation;
	}

	public void setOfflineCardOperation(OfflineCardOperationEO offlineCardOperation) {
		this.offlineCardOperation = offlineCardOperation;
	}
}
