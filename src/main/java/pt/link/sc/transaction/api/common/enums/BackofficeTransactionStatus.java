package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum BackofficeTransactionStatus implements PersistentEnum<Integer> {
	NOT_PROCESSED				(IDs.NOT_PROCESSED, 		"notProcessed", 			false),
	PROCESSING					(IDs.PROCESSING, 			"processing", 				false),
	VALID						(IDs.VALID, 				"valid", 					true),
	INVALID						(IDs.INVALID, 				"invalid", 					true),
	ERROR						(IDs.ERROR, 				"error", 					false),
//	INTERRUPTED					(IDs.INTERRUPTED, 			"interrupted", 				false),
	FOR_PROCESSING				(IDs.FOR_PROCESSING,		"forProcessing", 			false),
	PENDING_PREVIOUS			(IDs.PENDING_PREVIOUS,		"incompleteValidation", 	false),
	DUPLICATE					(IDs.DUPLICATE,				"duplicate", 				true);

	
	
	private Integer id;
	private String name;
	private boolean isFinal;

	private BackofficeTransactionStatus(Integer id, String name, boolean isFinal) {
		this.id = id;
		this.name = name;
		this.isFinal = isFinal;
	}

	@Override
	public String getLabelResourceId() {
		return "enum.backofficeTransactionStatus." + name + ".label";
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	
	public class IDs {
		public static final int NOT_PROCESSED = 0;
		public static final int PROCESSING = 1;
		public static final int VALID = 2;
		public static final int INVALID = 3;
		public static final int ERROR = 4;
		public static final int INTERRUPTED = 5;
		public static final int FOR_PROCESSING = 6;
		public static final int PENDING_PREVIOUS = 7;
		public static final int DUPLICATE = 8;
	}

}