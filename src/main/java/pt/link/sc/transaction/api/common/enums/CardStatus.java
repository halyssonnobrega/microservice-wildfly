package pt.link.sc.transaction.api.common.enums;

import java.util.List;

import com.google.common.collect.ImmutableList;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum CardStatus implements PersistentEnum<Integer> {

    // @formatter:off
    NOT_DISTRIBUTED	(IDs.NOT_DISTRIBUTED_ID,	"notDistributed",   ImmutableList.of(PhysicalCardStatus.CLEAR)),
    DISTRIBUTED		(IDs.DISTRIBUTED_ID, 		"distributed",      ImmutableList.of(PhysicalCardStatus.CLEAR)),
	ACTIVE			(IDs.ACTIVE_ID, 			"active",           ImmutableList.of(PhysicalCardStatus.ACTIVE)),
	EXPIRED			(IDs.EXPIRED_ID, 			"expired",          ImmutableList.of(PhysicalCardStatus.ACTIVE, PhysicalCardStatus.INVALIDATED)),
	BLACKLISTED		(IDs.BLACKLISTED_ID, 		"blacklisted",      ImmutableList.of(PhysicalCardStatus.INVALIDATED)),
	INVALIDATED		(IDs.INVALIDATED_ID, 		"invalidated",      ImmutableList.of(PhysicalCardStatus.INVALIDATED)),
	DESTROYED		(IDs.DESTROYED_ID, 			"destroyed",        ImmutableList.of(PhysicalCardStatus.INVALIDATED)),
	REFUNDED		(IDs.REFUNDED_ID, 			"refunded",         ImmutableList.of(PhysicalCardStatus.INVALIDATED)),
	UNKNOWN			(IDs.UNKNOWN_ID, 			"unknown");
    // @formatter:on

    private final Integer id;
    private final String name;
    private List<PhysicalCardStatus> allowedPhysicalCardStatus;

    private CardStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.allowedPhysicalCardStatus = ImmutableList.of();
    }

    private CardStatus(Integer id, String name, List<PhysicalCardStatus> allowedPhysicalCardStatus) {
        this.id = id;
        this.name = name;
        this.allowedPhysicalCardStatus = allowedPhysicalCardStatus;
    }

    @Override
    public String getLabelResourceId() {
        return "enum.cardStatus.label." + name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }


    public class IDs {
        public static final int NOT_DISTRIBUTED_ID = 0;
        public static final int DISTRIBUTED_ID = 1;
        public static final int ACTIVE_ID = 2;
        public static final int EXPIRED_ID = 3;
        public static final int BLACKLISTED_ID = 4;
        public static final int INVALIDATED_ID = 5;
        public static final int DESTROYED_ID = 6;
        public static final int REFUNDED_ID = 7;
        public static final int UNKNOWN_ID = 8;
    }
}