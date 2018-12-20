package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum OfflineTransactionStatus implements PersistentEnum<Integer>{
	REGISTED(0, "registed"),
	ERROR(1, "error");
	
	private Integer id;
	private String name;
	private OfflineTransactionStatus(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String getLabelResourceId() {
		return "enum.offlineTransactionStatus." + name + ".label";
	}
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public String getName() {
		return name;
	}

	
}