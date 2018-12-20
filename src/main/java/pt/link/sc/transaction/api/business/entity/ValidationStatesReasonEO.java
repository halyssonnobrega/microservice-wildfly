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
@Table(name = "VALIDATION_STATES_REASONS", schema = "transactions")
public class ValidationStatesReasonEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8426490927622467745L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALIDATION_STATE_ID", nullable = false)
	private ValidationStateEO validationState;
	
	@Column(name = "VALIDATION_STATE_REASON_CODE", nullable = false, length = 50)
	private String code;
	
	@Column(name = "VALIDATION_STATE_REASON_NAME", nullable = false, length = 80)
	private String name;
	
	@Column(name = "ACTIVE", nullable = false)
	private int active;

	public Long getId() {
		return this.id;
	}

	public ValidationStateEO getValidationState() {
		return validationState;
	}

	public void setValidationState(ValidationStateEO validationState) {
		this.validationState = validationState;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
