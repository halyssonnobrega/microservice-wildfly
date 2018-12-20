package pt.link.sc.transaction.api.business.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import pt.link.sc.transaction.api.common.enums.EnumUtil;
import pt.link.sc.transaction.api.common.enums.OfflineTransactionStatus;

@Entity
@Table(name = "OFFLINE_TRANSACTION_OPERATION")
public class OfflineTransactionOperationEO extends AbstractAuditInfoEO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3145509860806399579L;

	@Transient
	private Logger log = LoggerFactory.getLogger(OfflineTransactionOperationEO.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "OFFLINE_CARD_OPERATION_ID")
	private OfflineCardOperationEO offlineCardOperation;

	@Column(name = "STATUS")
	private Integer statusId;
	
	@Column(name = "MESSAGE_CODE")
	private String messageCode;

	@Column(name = "ARGS_JSON")
	private String argsJson;

	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "CARD_NUMBER")
	private BigInteger cardNumber;
	
	@Column(name = "TRANSACTION_ID", length=255)
	private String transactionId;

	public Long getId() {
		return id;
	}

	public OfflineCardOperationEO getOfflineCardOperation() {
		return offlineCardOperation;
	}

	public void setOfflineCardOperation(OfflineCardOperationEO offlineCardOperation) {
		this.offlineCardOperation = offlineCardOperation;
	}
	
	@Transient
	public Object[] getArgs() {
		if(StringUtils.isBlank(argsJson)) {
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(argsJson, Object[].class);
		} catch (Exception e) {
			log.error("Could not get args from offline transaction operation. Continuing with new Object[]{argsJson}", e);
			return new Object[] {argsJson};
		}
	}

	public String getArgsJson() {
		return argsJson;
	}

	public void setArgsJson(String argsJson) {
		this.argsJson = argsJson;
	}



	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BigInteger getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	
	@Transient
	public OfflineTransactionStatus getStatus() {
		return EnumUtil.getById(this.statusId, OfflineTransactionStatus.class).orElse(null);
	}

	@Transient
	public void setStatus(OfflineTransactionStatus offlineOperationStatus) {
		this.statusId = EnumUtil.getEnumId(offlineOperationStatus);
	}
	
}
