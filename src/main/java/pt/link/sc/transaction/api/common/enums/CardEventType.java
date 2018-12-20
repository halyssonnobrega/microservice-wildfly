package pt.link.sc.transaction.api.common.enums;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

/**
 * @author mario.macarico
 * <p>
 * These are the operations that change the card state.
 * <p>
 * Invalidation state is set automatically when a card event of
 * invalidation type is created based on an invalidation card
 * transaction
 */
public enum CardEventType implements PersistentEnum<Integer> {
    REGISTRATION(
            0,
            "registration",
            CardStatus.NOT_DISTRIBUTED,
            ImmutableList.of(),
            true),
    DISTRIBUTION(
            1,
            "distribution",
            CardStatus.DISTRIBUTED,
            ImmutableList.of(CardStatus.NOT_DISTRIBUTED),
            true),
    ACTIVATION(
            2,
            "activation",
            CardStatus.ACTIVE,
            ImmutableList.of(CardStatus.DISTRIBUTED),
            true),
    INVALIDATION(
            3,
            "invalidation",
            CardStatus.INVALIDATED,
            ImmutableList.of(CardStatus.ACTIVE, CardStatus.BLACKLISTED, CardStatus.EXPIRED, CardStatus.REFUNDED),
            true),
    EXPIRATION(
            4,
            "expiration",
            CardStatus.EXPIRED,
            ImmutableList.of(CardStatus.ACTIVE, CardStatus.BLACKLISTED),
            true),
    DESTRUCTION(
            5,
            "destruction",
            CardStatus.DESTROYED,
            //All status except destoyed
            Arrays.stream(CardStatus.values()).filter(s -> CardStatus.DESTROYED != s).collect(Collectors.toList()),
            true),
    BLACKLIST(
            6,
            "blacklist",
            CardStatus.BLACKLISTED,
            Arrays.stream(CardStatus.values()).filter(s -> !ImmutableList.of(CardStatus.DESTROYED, CardStatus.INVALIDATED).contains(s)).collect(Collectors.toList()),
            true),
    REFUND(7,
            "refund",
            CardStatus.REFUNDED,
            ImmutableList.of(CardStatus.ACTIVE),
            true),
    MARKED_AS_VALID(
            8,
            "markAsValid",
            CardStatus.ACTIVE,
            ImmutableList.of(CardStatus.BLACKLISTED, CardStatus.UNKNOWN),
            true),
    REHABILITATION(
            9,
            "rehabilitated",
            CardStatus.ACTIVE,
            ImmutableList.of(CardStatus.INVALIDATED),
            true),
    VALIDATION_FAILED(
            10,
            "validationFailed",
            null,
            ImmutableList.of(),
            true),
    VALIDATION_RECOVERED(
            11,
            "validationRecovered",
            null,
            ImmutableList.of(),
            true),
    UNKNOWN_CARD_CREATED(
            12,
            "unknownCardCreated",
            CardStatus.UNKNOWN,
            null,
            true),
    UNKNOWN_CARD_NUMBER_CREATED(
            13,
            "unknownCardNumberCreated",
            null,
            ImmutableList.of(),
            true),
    RECHARGE(
            14,
            "recharge",
            null,
            ImmutableList.of(CardStatus.DISTRIBUTED, CardStatus.ACTIVE),
            false),
    UNDO_DISTRIBUTION(
            15,
            "undoDistribution",
            CardStatus.NOT_DISTRIBUTED,
            ImmutableList.of(CardStatus.DISTRIBUTED),
            true),
    ;

    private Integer id;
    private String name;
    private CardStatus resultingCardStatus;
    private Collection<CardStatus> requiredCardStatus;
    private boolean registerEvent = true;

    private CardEventType(Integer id, String name, CardStatus resultingCardStatus, Collection<CardStatus> requiredCardStatus, boolean registerEvent) {
        this.id = id;
        this.name = name;
        this.resultingCardStatus = resultingCardStatus;
        this.requiredCardStatus = requiredCardStatus;
        this.setRegisterEvent(registerEvent);
    }

    @Override
    public String getLabelResourceId() {
        return "enum.cardEventType." + name + ".label";
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public CardStatus getResultingCardStatus() {
        return resultingCardStatus;
    }

    public void setResultingCardStatus(CardStatus resultingCardStatus) {
        this.resultingCardStatus = resultingCardStatus;
    }

    public Collection<CardStatus> getRequiredCardStatus() {
        return requiredCardStatus;
    }

    public void setRequiredCardStatus(Collection<CardStatus> requiredCardStatus) {
        this.requiredCardStatus = requiredCardStatus;
    }

    public boolean isRegisterEvent() {
        return registerEvent;
    }

    public void setRegisterEvent(boolean registerEvent) {
        this.registerEvent = registerEvent;
    }
}