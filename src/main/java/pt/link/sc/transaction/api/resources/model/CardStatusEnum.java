package pt.link.sc.transaction.api.resources.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import pt.link.sc.transaction.api.common.enums.CardStatus;
import pt.link.sc.transaction.api.common.util.MappingEnum;

@XmlType(name = "CardStatusEnum")
@XmlEnum(String.class)
public enum CardStatusEnum implements MappingEnum<CardStatus> {
    //@formatter:off
	@XmlEnumValue("distributed")
	DISTRIBUTED(	"distributed", CardStatus.DISTRIBUTED),
	@XmlEnumValue("active")
	ACTIVE(			"active", CardStatus.ACTIVE),
	@XmlEnumValue("expired")
	EXPIRED(		"expired", CardStatus.EXPIRED),
	@XmlEnumValue("blacklisted")
	BLACKLISTED(	"blacklisted", CardStatus.BLACKLISTED),
	@XmlEnumValue("invalidated")
	INVALIDATED(	"invalidated", CardStatus.INVALIDATED),
	@XmlEnumValue("destroyed")
	DESTROYED(		"destroyed", CardStatus.DESTROYED),
	@XmlEnumValue("refunded")
	REFUNDED(		"refunded", CardStatus.REFUNDED),
	@XmlEnumValue("notDistributed")
	NOT_DISTRIBUTED(	"notDistributed", CardStatus.NOT_DISTRIBUTED);
	//@formatter:on

    private String value;
    private CardStatus mappingObject;

    CardStatusEnum(String v, CardStatus mappingObject) {
        this.value = v;
        this.mappingObject = mappingObject;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static CardStatusEnum fromValue(String v) {
        for (CardStatusEnum b : CardStatusEnum.values()) {
            if (b.value.equals(v)) {
                return b;
            }
        }
        return null;
    }

    public static CardStatusEnum fromCardStatus(CardStatus v) {
        if (v == null) {
            return null;
        }
        return fromValue(v.getName());
    }

    @Override
    public CardStatus getMappingObject() {
        return mappingObject;
    }
}