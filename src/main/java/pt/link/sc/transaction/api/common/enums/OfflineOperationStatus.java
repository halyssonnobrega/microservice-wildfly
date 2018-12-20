package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum OfflineOperationStatus implements PersistentEnum<Integer> {
	NOT_PROCESSED		(0, "notProcessed"),
	PROCESSING			(1, "processing"), 
	PROCESSED			(2, "processed"),
	ERROR				(3, "error");

	private Integer id;
	private String name;

	private OfflineOperationStatus(Integer id, String name) {
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
		return "enum.offlineOperationStatus." + name + ".label";
	}

}