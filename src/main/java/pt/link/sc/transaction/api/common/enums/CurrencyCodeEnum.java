package pt.link.sc.transaction.api.common.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CurrencyCodeEnum")
@XmlEnum(String.class)
public enum CurrencyCodeEnum {

	@XmlEnumValue("CHF")
	CHF("CHF"), 
	@XmlEnumValue("EUR")
	EUR("EUR")
	;

	private String value;

	CurrencyCodeEnum(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	public static CurrencyCodeEnum fromValue(String v) {
		for (CurrencyCodeEnum b : CurrencyCodeEnum.values()) {
			if (b.value.equals(v)) {
				return b;
			}
		}
		return null;
	}
}
