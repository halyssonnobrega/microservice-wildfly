package pt.link.sc.transaction.api.business.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import pt.link.sc.transaction.api.common.enums.EnumUtil;
import pt.link.sc.transaction.api.common.enums.OfflineOperationStatus;

@Entity
@Table(name = "OFFLINE_CARD_OPERATION", indexes = {
        @Index(columnList = "OFFLINE_OPERATION_STATUS"),
        @Index(columnList = "UUID"),
        @Index(columnList = "CORRELATION_ID")
})
public class OfflineCardOperationEO extends AbstractAuditInfoEO {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4090284003752391187L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "CORRELATION_ID", length = 255)
    private String correlationId;

    @Lob
    @Column(name = "JSON_CONTENT")
    private String jsonContent;

    @Column(name = "JSON_CONTENT_CLASS_TYPE_NAME")
    private String jsonContentClassTypeName;

    @Column(name = "OFFLINE_OPERATION_STATUS")
    private Integer offlineOperationStatusId;

    @OneToMany(mappedBy = "offlineCardOperation", fetch = FetchType.LAZY)
    private List<OfflineTransactionOperationEO> offlineTransactionOperations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHANNEL_POINT_ID")
    private ChannelPointEO channelPoint;

    public Long getId() {
        return id;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public String getJsonContentClassTypeName() {
        return jsonContentClassTypeName;
    }

    public void setJsonContentClassTypeName(String jsonContentClassTypeName) {
        this.jsonContentClassTypeName = jsonContentClassTypeName;
    }

    @Transient
    public OfflineOperationStatus getOfflineOperationStatus() {
        return EnumUtil.getById(offlineOperationStatusId, OfflineOperationStatus.class).orElse(null);
    }

    @Transient
    public void setOfflineOperationStatus(OfflineOperationStatus offlineOperationStatus) {
        this.offlineOperationStatusId = EnumUtil.getEnumId(offlineOperationStatus);
    }

    public List<OfflineTransactionOperationEO> getOfflineTransactionOperations() {
        return offlineTransactionOperations;
    }

    public void setOfflineTransactionOperations(List<OfflineTransactionOperationEO> offlineTransactionOperations) {
        this.offlineTransactionOperations = offlineTransactionOperations;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "OfflineCardOperation [id=" + id + ", uuid=" + uuid + ", correlationId=" + correlationId + ", jsonContent=" + jsonContent + ", jsonContentClassTypeName=" + jsonContentClassTypeName + ", offlineOperationStatusId=" + offlineOperationStatusId + ", offlineTransactionOperations=" + offlineTransactionOperations + "]";
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public ChannelPointEO getChannelPoint() {
        return channelPoint;
    }

    public void setChannelPoint(ChannelPointEO channelPoint) {
        this.channelPoint = channelPoint;
    }
}