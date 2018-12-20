package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VALIDATION_TYPES", schema = "transactions")
public class ValidationTypeEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499443349263978393L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "VALIDATION_TYPE_NAME", nullable = false, length = 35)
	private String name;
	
	@Column(name = "VALIDATION_TYPE_CODE", length = 15)
	private String code;
	
	@Column(name = "ACTIVE")
	private Integer active;

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
}
