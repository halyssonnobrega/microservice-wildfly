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
@Table(name = "CARDS", schema = "transactions")
public class CardEO extends AbstractAuditInfoEO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8555673328606254115L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "CARD_NUMBER")
	private Integer cardNumber;
	
	@Column(name = "CARD_ISSUER")
	private Integer cardIssuer;
	
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	
	@Column(name = "CARD_SERIAL_NUMBER")
	private Integer cardSerialNumber;
	
	@Column(name = "CARD_STATUS")
	private Integer cardStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACTIVATION_DATE", length = 27)
	private Date activationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE", length = 27)
	private Date expirationDate;
	
	@Column(name = "CARD_TYPE")
	private Integer cardType;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "card", cascade = CascadeType.ALL,  targetEntity = AuthorizationEO.class)
	private List<AuthorizationEO> authorizations;

	public Long getId() {
		return this.id;
	}

	public Integer getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getCardIssuer() {
		return this.cardIssuer;
	}

	public void setCardIssuer(Integer cardIssuer) {
		this.cardIssuer = cardIssuer;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getCardSerialNumber() {
		return this.cardSerialNumber;
	}

	public void setCardSerialNumber(Integer cardSerialNumber) {
		this.cardSerialNumber = cardSerialNumber;
	}

	public Integer getCardStatus() {
		return this.cardStatus;
	}

	public void setCardStatus(Integer cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Date getActivationDate() {
		return this.activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getCardType() {
		return this.cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public List<AuthorizationEO> getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(List<AuthorizationEO> authorizations) {
		this.authorizations = authorizations;
	}
}
