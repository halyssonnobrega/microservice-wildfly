package pt.link.sc.transaction.api.common.enums;

import java.util.Collection;

import com.google.common.collect.ImmutableList;

import pt.link.sc.transaction.api.business.dto.OperationAuthorizationRequest;
import pt.link.sc.transaction.api.business.exceptions.InvalidOperationException;
import pt.link.sc.transaction.api.common.util.PersistentEnum;

/**
 * @author mario.macarico
 * <p>
 * Only operations that required authorization
 */

public enum AuthorizationOperationType implements PersistentEnum<Integer> {
    RELOAD_AUTH(0,
            "activation",
            ImmutableList.of(TransactionType.RELOAD),
            ThreeState.MUST_EXIST,
            CardEventType.ACTIVATION,
            false,
            false,
            true);

    private Integer id;
    private String name;
    private Collection<TransactionType> allowedTransactionsTypes;
    private ThreeState transactionExistence = ThreeState.MUST_NOT_EXISTS;
    private CardEventType cardEventType;

    private boolean requiresAmount;
    private boolean requiresCardNumber;
    private boolean requiresCurrencyCode;

    private AuthorizationOperationType(Integer id, String name, Collection<TransactionType> allowedTransactionsTypes, ThreeState transactionExistence, CardEventType cardOperationType, boolean requiresAmount, boolean requiresCardNumber, boolean requiresCurrencyCode) {
        this.id = id;
        this.name = name;
        this.allowedTransactionsTypes = allowedTransactionsTypes;
        this.transactionExistence = transactionExistence;
        this.cardEventType = cardOperationType;
        this.requiresAmount = requiresAmount;
        this.requiresCardNumber = requiresCardNumber;
        this.requiresCurrencyCode = requiresCurrencyCode;
    }

    @Override
    public String getLabelResourceId() {
        return "enum.autorizationOperationType." + name + ".label";
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public CardEventType getCardEventType() {
        return cardEventType;
    }

    public void setCardEventType(CardEventType cardOperationType) {
        this.cardEventType = cardOperationType;
    }

    public Collection<TransactionType> getAllowedTransactionsTypes() {
        return allowedTransactionsTypes;
    }

    public void setAllowedTransactionsTypes(Collection<TransactionType> allowedTransactionsTypes) {
        this.allowedTransactionsTypes = allowedTransactionsTypes;
    }

    public ThreeState getTransactionExistence() {
        return transactionExistence;
    }

    public void setTransactionExistence(ThreeState transactionExistence) {
        this.transactionExistence = transactionExistence;
    }

    public boolean isRequiresAmount() {
        return requiresAmount;
    }

    public boolean isRequiresCardNumber() {
        return requiresCardNumber;
    }

    public boolean isRequiresCurrencyCode() {
        return requiresCurrencyCode;
    }

    public void validateAuthoriationRequestParameters(OperationAuthorizationRequest operationAuthorizationRequest) {
        if (requiresCardNumber && operationAuthorizationRequest.getCardNumber() == null) {
            throw new InvalidOperationException(InvalidOperationCode.CARD_NUMBER_IS_REQUIRED, new Object[]{"card number is required for operation"});
        }
        if (requiresAmount && operationAuthorizationRequest.getAmount() == null) {
            throw new InvalidOperationException(InvalidOperationCode.AMOUNT_IS_REQUIRED, new Object[]{"amount is required for operation"});
        }
        if (requiresCurrencyCode && operationAuthorizationRequest.getCurrencyCode() == null) {
            throw new InvalidOperationException(InvalidOperationCode.CURRENCY_IS_REQUIRED, new Object[]{"currency code required for operation"});
        }
    }
}