package pt.link.sc.transaction.api.business.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pt.link.sc.transaction.api.common.enums.AuthorizationOperationType;
import pt.link.sc.transaction.api.common.enums.AuthorizationStatus;
import pt.link.sc.transaction.api.common.enums.EnumUtil;

@Entity
@Table(name = "AUTHORIZATIONS", schema = "transactions")
public class AuthorizationEO extends AbstractAuditInfoEO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8990418176599636857L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
    @Column(name = "AUTHORIZATION_TYPE_ID")
    private Integer authorizationOperationTypeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_ID")
	private CardEO card;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHANNEL_POINT_ID")
	private ChannelPointEO channelPoint;
	
	@Column(name = "UUID")
	private String uuid;
	
	@Column(name = "AMOUNT")
	private Long amount;
	
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	
	@Column(name = "AUTHORIZATION_STATE")
	private Integer authorizationStatusId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PERFORMED_ON", length = 27)
	private Date performedOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CARD_EXPIRATION_DATE", length = 27)
	private Date cardExpirationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AUTHORIZATION_EXPIRATION_DATE", length = 27)
	private Date authorizationExpirationDate;
	
	@Column(name = "REASON")
	private String reason;

	public Long getId() {
		return this.id;
	}

	public CardEO getCard() {
		return card;
	}

	public void setCard(CardEO card) {
		this.card = card;
	}

	public ChannelPointEO getChannelPoint() {
		return channelPoint;
	}

	public void setChannelPoint(ChannelPointEO channelPoint) {
		this.channelPoint = channelPoint;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

    @Transient
    public AuthorizationOperationType getAuthorizationOperationType() {
        return EnumUtil.getById(authorizationOperationTypeId, AuthorizationOperationType.class).orElse(null);
    }

    @Transient
    public void setAuthorizationOperationType(AuthorizationOperationType authorizationOperationType) {
        this.authorizationOperationTypeId = EnumUtil.getEnumId(authorizationOperationType);
    }
	
    @Transient
    public AuthorizationStatus getAuthorizationStatus() {
        return EnumUtil.getById(authorizationStatusId, AuthorizationStatus.class).orElse(null);
    }

    @Transient
    public void setAuthorizationStatus(AuthorizationStatus authorizationStatus) {
        this.authorizationStatusId = EnumUtil.getEnumId(authorizationStatus);
    }

	public Date getPerformedOn() {
		return this.performedOn;
	}

	public void setPerformedOn(Date performedOn) {
		this.performedOn = performedOn;
	}

	public Date getCardExpirationDate() {
		return this.cardExpirationDate;
	}

	public void setCardExpirationDate(Date cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}

	public Date getAuthorizationExpirationDate() {
		return this.authorizationExpirationDate;
	}

	public void setAuthorizationExpirationDate(Date authorizationExpirationDate) {
		this.authorizationExpirationDate = authorizationExpirationDate;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
