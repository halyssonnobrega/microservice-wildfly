package pt.link.sc.transaction.api.common.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import pt.link.sc.transaction.api.common.util.MappingEnum;

@XmlType(name = "AutorizationOperationTypeEnum")
@XmlEnum(String.class)
public enum AuthorizationOperationTypeEnum implements MappingEnum<AuthorizationOperationType> {

	@XmlEnumValue("reloadAuthorization")
	RELOAD_AUTH("reloadAuthorization", AuthorizationOperationType.RELOAD_AUTH), 
	;

	private String value;
	private AuthorizationOperationType mappingObject;

	AuthorizationOperationTypeEnum(String v, AuthorizationOperationType mappingObject) {
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

	public static AuthorizationOperationTypeEnum fromValue(String v) {
		for (AuthorizationOperationTypeEnum b : AuthorizationOperationTypeEnum.values()) {
			if (b.value.equals(v)) {
				return b;
			}
		}
		return null;
	}
	
	public static AuthorizationOperationTypeEnum byMapping(AuthorizationOperationType mapping) {
		for (AuthorizationOperationTypeEnum b : AuthorizationOperationTypeEnum.values()) {
			if (b.mappingObject.equals(mapping)) {
				return b;
			}
		}
		return null;
	}
	
	
	

	@Override
	public AuthorizationOperationType getMappingObject() {
		return mappingObject;
	}
}