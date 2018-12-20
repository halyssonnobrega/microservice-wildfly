package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_STATES_REASONS", schema = "transactions")
public class TransactionStatesReasonEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8062356507360206920L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTION_STATE_ID", nullable = false)
	private TransactionStateEO state;
	
	@Column(name = "ACTIVE", nullable = false)
	private int active;
	
	@Column(name = "TRANSACTION_STATE_REASON_CODE", nullable = false, length = 50)
	private String code;

	@Column(name = "TRANSACTION_STATE_REASON_NAME", nullable = false, length = 100)
	private String name;

	public Long getId() {
		return id;
	}

	public TransactionStateEO getState() {
		return state;
	}

	public void setState(TransactionStateEO state) {
		this.state = state;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
