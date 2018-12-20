package pt.link.sc.transaction.api.resources.model;

import java.math.BigInteger;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pt.link.sc.transaction.api.common.enums.AuthorizationOperationTypeEnum;
import pt.link.sc.transaction.api.common.enums.CurrencyCodeEnum;
import pt.link.sc.transaction.api.common.mapper.CardInfo;
import pt.link.sc.transaction.api.common.util.CsvUtil;
import pt.link.sc.transaction.api.common.validationGroups.ActivationGroup;
import pt.link.sc.transaction.api.common.validationGroups.DestructionGroup;
import pt.link.sc.transaction.api.common.validationGroups.RechargeGroup;
import pt.link.sc.transaction.api.common.validationGroups.RefundGroup;
import pt.link.sc.transaction.api.common.validationGroups.RehabilitatedGroup;

@ApiModel(description = "Represents an authorization request")
public class AuthorizationRequest {

    @ApiModelProperty(value = "The card serial number in hexadecimal", allowEmptyValue = false, example = "0433458AD55197")
    @NotNull(groups = {RechargeGroup.class, ActivationGroup.class, RefundGroup.class, DestructionGroup.class, RehabilitatedGroup.class})
    private String cardSerialNumberHexString;

    @ApiModelProperty(value = "The card tech type identifier.", allowEmptyValue = false, example = "8")
    @NotNull(groups = {RechargeGroup.class, ActivationGroup.class, RefundGroup.class, DestructionGroup.class, RehabilitatedGroup.class})
    private Integer cardTechTypeIdentifier;

    @ApiModelProperty(value = "The card number. Required for recharge operations. Ignored on other cases")
    @NotNull(groups = {RechargeGroup.class})
    private BigInteger cardNumber;

    @ApiModelProperty(value = "The card Cissuer. Required for activation operations. Empty on other cases. 1 for TPG.", example = "1")
    @NotNull(groups = ActivationGroup.class)
    private Integer cardIssuer;

    @ApiModelProperty(value = "The card info in json as returned from sdsAgents. When used it will override the cardSerial number, tech type, card number and card issuer")
    private String cardInfo;

    @ApiModelProperty(value = "The target amount requested for the authorization. Required for recharge. Empty on other cases. Value is in cents.")
    @NotNull(groups = {RechargeGroup.class})
    @Null(groups = {ActivationGroup.class, RefundGroup.class, DestructionGroup.class, RehabilitatedGroup.class})
    private Long targetAmount;

    @ApiModelProperty(value = "The target amount requested for the authorization. Required for recharge. Ignored on other cases.")
    @NotNull(groups = {RechargeGroup.class})
    private Integer contractPointerId;

    @ApiModelProperty(value = "The reason for the transaction")
    private String reason;

    @ApiModelProperty(value = "The target currency code requested for the authorization. Required for recharge authorizations. Empty on other cases.")
    @NotNull(groups = {RechargeGroup.class})
    private CurrencyCodeEnum targetCurrencyCode;

    @ApiModelProperty(value = "The desired operation type to be performed by the authorization.", allowEmptyValue = false)
    @NotNull
    private AuthorizationOperationTypeEnum authorizationOperationType;

    @ApiModelProperty(value = "The channel point identifier.")
    private String channelPointId;

    @ApiModelProperty(value = "The channel point description.")
    private String channelPointDescription;

    public Long getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public CurrencyCodeEnum getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    public void setTargetCurrencyCode(CurrencyCodeEnum targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

    public AuthorizationOperationTypeEnum getAuthorizationOperationType() {
        return authorizationOperationType;
    }

    public void setAuthorizationOperationType(AuthorizationOperationTypeEnum authorizationOperationType) {
        this.authorizationOperationType = authorizationOperationType;
    }

    public String getCardSerialNumberHexString() {
        return cardSerialNumberHexString;
    }

    public void setCardSerialNumberHexString(String cardSerialNumberHexString) {
        this.cardSerialNumberHexString = cardSerialNumberHexString;
    }

    public Integer getCardTechTypeIdentifier() {
        return cardTechTypeIdentifier;
    }

    public void setCardTechTypeIdentifier(Integer cardTechTypeIdentifier) {
        this.cardTechTypeIdentifier = cardTechTypeIdentifier;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(Integer cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    public String getChannelPointId() {
        return channelPointId;
    }

    public void setChannelPointId(String channelPointId) {
        this.channelPointId = channelPointId;
    }

    public String getChannelPointDescription() {
        return channelPointDescription;
    }

    public void setChannelPointDescription(String channelPointDescription) {
        this.channelPointDescription = channelPointDescription;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public Integer getContractPointerId() {
        return contractPointerId;
    }

    public void setContractPointerId(Integer contractPointerId) {
        this.contractPointerId = contractPointerId;
    }

    @Override
    public String toString() {
        return "AuthorizationRequest [cardSerialNumberHexString=" + cardSerialNumberHexString + ", cardTechTypeIdentifier=" + cardTechTypeIdentifier + ", cardNumber=" + cardNumber + ", cardIssuer=" + cardIssuer + ", targetAmount=" + targetAmount + ", reason=" + reason + ", targetCurrencyCode=" + targetCurrencyCode
                + ", authorizationOperationType=" + authorizationOperationType + ", channelPointId=" + channelPointId + ", channelPointDescription=" + channelPointDescription + "]";
    }

    public void initFromCardInfo() {
        if (this.cardInfo != null) {
            CardInfo cardInfo = null;//JsonUtils.fromJsonOrFail(CardInfo.class, this.cardInfo);
            setCardIssuer(cardInfo.getCardNumber().getAppIssuer().intValue());
            setCardNumber(new BigInteger(Optional.ofNullable(cardInfo.getCardNumber().getCardNumber())
                    .orElse(cardInfo.getCardNumber().getAppCardNumber())
                    .toString()));
            setCardTechTypeIdentifier(cardInfo.getCardTechType());
            setCardSerialNumberHexString(CsvUtil.buildCardSerialNumber(cardInfo.getCardSerialNumber().getHighPart(), cardInfo.getCardSerialNumber().getLowPart()));
        }
    }

}
