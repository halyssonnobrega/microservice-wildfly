package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VALIDATION_STATES", schema = "transactions")
public class ValidationStateEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8359233197575365982L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "VALIDATION_STATE_CODE", nullable = false, length = 3)
	private String code;
	
	@Column(name = "VALIDATION_STATE_NAME", nullable = false, length = 30)
	private String name;
	
	@Column(name = "ACTIVE", nullable = false)
	private int active;

	public Long getId() {
		return this.id;
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
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}
