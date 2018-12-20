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
@Table(name = "TRANSACTION_PROFILES", schema = "transactions")
public class TransactionProfileEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6936508973302146981L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTION_ID", nullable = false)
	private TransactionEO transaction;
	
	@Column(name = "PROFILE_CODE")
	private Integer profileCode;
	
	@Column(name = "PROF_COMPANY_OPER")
	private Integer profCompanyOper;

	public Long getId() {
		return this.id;
	}

	public TransactionEO getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionEO transaction) {
		this.transaction = transaction;
	}

	public Integer getProfileCode() {
		return this.profileCode;
	}

	public void setProfileCode(Integer profileCode) {
		this.profileCode = profileCode;
	}

	public Integer getProfCompanyOper() {
		return this.profCompanyOper;
	}

	public void setProfCompanyOper(Integer profCompanyOper) {
		this.profCompanyOper = profCompanyOper;
	}

}
