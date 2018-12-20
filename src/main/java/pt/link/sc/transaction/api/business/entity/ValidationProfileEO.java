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
@Table(name = "VALIDATION_PROFILES", schema = "transactions")
public class ValidationProfileEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6529019938703916012L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALIDATION_ID", nullable = false)
	private ValidationEO validation;
	
	@Column(name = "PROFILE_CODE")
	private Integer profileCode;
	
	@Column(name = "PROF_COMPANY_OPER")
	private Integer profCompanyOper;

	public Long getId() {
		return this.id;
	}

	public ValidationEO getValidation() {
		return validation;
	}

	public void setValidation(ValidationEO validation) {
		this.validation = validation;
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
