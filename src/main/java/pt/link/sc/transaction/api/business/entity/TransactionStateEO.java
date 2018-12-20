package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_STATES", schema = "transactions")
public class TransactionStateEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -20349275134377644L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ACTIVE", nullable = false)
	private int active;
	
	@Column(name = "TRANSACTION_STATE_CODE", nullable = false, length = 2)
	private String transactionStateCode;
	
	@Column(name = "TRANSACTION_STATE_NAME", nullable = false, length = 100)
	private String transactionStateName;

	public Long getId() {
		return this.id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getTransactionStateCode() {
		return this.transactionStateCode;
	}

	public void setTransactionStateCode(String transactionStateCode) {
		this.transactionStateCode = transactionStateCode;
	}

	public String getTransactionStateName() {
		return this.transactionStateName;
	}

	public void setTransactionStateName(String transactionStateName) {
		this.transactionStateName = transactionStateName;
	}
}
