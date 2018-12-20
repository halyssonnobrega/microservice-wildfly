package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_TYPES", schema = "transactions")
public class TransactionTypeEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5154019873682635736L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ACTIVE", nullable = false)
	private int active;
	
	@Column(name = "TRANSACTION_TYPE_CODE", nullable = false, length = 20)
	private String code;
	
	@Column(name = "TRANSACTION_TYPE_NAME", nullable = false, length = 100)
	private String name;

	public Long getId() {
		return this.id;
	}

	public int getActive() {
		return this.active;
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
