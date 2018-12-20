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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INTEGRATION_LOGS", schema = "transactions")
public class IntegrationLogEO extends AbstractAuditInfoEO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3069236020435262697L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "TYPE_ID", nullable = false)
	private long typeId;
	
	@Column(name = "STATE_ID", nullable = false)
	private long stateId;
	
	@Column(name = "SENDER_ENTITY_ID")
	private Integer senderEntityId;
	
	@Column(name = "RECEIVER_ENTITY_ID")
	private Integer receiverEntityId;
	
	@Column(name = "SOURCE_MESSAGE_ID", length = 40)
	private String sourceMessageId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INTEGRATION_DATE", length = 27)
	private Date integrationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TRANSFER_DATE", length = 27)
	private Date transferDate;
	
	@Column(name = "ERROR_DESC", length = 500)
	private String errorDesc;

	@Column(name = "FILE_PATH", length = 500)
	private String filePath;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "integrationLog", cascade = CascadeType.ALL,  targetEntity = ValidationEO.class)
	private List<ValidationEO> validations;

	public Long getId() {
		return this.id;
	}

	public long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public long getStateId() {
		return this.stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public Integer getSenderEntityId() {
		return this.senderEntityId;
	}

	public void setSenderEntityId(Integer senderEntityId) {
		this.senderEntityId = senderEntityId;
	}

	public Integer getReceiverEntityId() {
		return this.receiverEntityId;
	}

	public void setReceiverEntityId(Integer receiverEntityId) {
		this.receiverEntityId = receiverEntityId;
	}

	public String getSourceMessageId() {
		return this.sourceMessageId;
	}

	public void setSourceMessageId(String sourceMessageId) {
		this.sourceMessageId = sourceMessageId;
	}

	public Date getIntegrationDate() {
		return this.integrationDate;
	}

	public void setIntegrationDate(Date integrationDate) {
		this.integrationDate = integrationDate;
	}

	public Date getTransferDate() {
		return this.transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public String getErrorDesc() {
		return this.errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<ValidationEO> getValidations() {
		return validations;
	}

	public void setValidations(List<ValidationEO> validations) {
		this.validations = validations;
	}

}
