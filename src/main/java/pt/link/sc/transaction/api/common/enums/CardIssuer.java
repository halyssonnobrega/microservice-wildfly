package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum CardIssuer implements PersistentEnum<Integer> {
	UNKNOWN		(0,"unknown"),
	TPG			(1,"tpg"),
	SCS			(2,"scs"),
	TPG_TEST	(3,"tpg_test");
	
	private Integer id;
	private String name;
	
	
	private CardIssuer(Integer id, String name) {
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
		return "enum.cardIssuer." + name + ".label";
	}	
}