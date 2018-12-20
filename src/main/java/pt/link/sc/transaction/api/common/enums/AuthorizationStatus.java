package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum AuthorizationStatus implements PersistentEnum<Integer> {
	NOT_PERFORMED	(0, "notPerformed"),
	PERFORMED		(1, "performed");
	
	private Integer id;
	private String name;
	
	
	private AuthorizationStatus(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getLabelResourceId() {
		return "enum.authorizationStatus." + name + ".label";
	}	
	
}