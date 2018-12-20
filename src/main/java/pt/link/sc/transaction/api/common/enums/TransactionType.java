package pt.link.sc.transaction.api.common.enums;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum TransactionType implements PersistentEnum<Integer> {
    UNKNOWN		(IDs.UNKNOWN, 	"unknown"),
    RELOAD		(IDs.RELOAD,  	"reloadTransactions"),
    VALIDATION	(IDs.VALIDATION, 		"validationTransactions")
    /*
     * TODO: To be defined
     * ,
    INSPECTION	(IDs.INSPECTION, "inspectionTransactions"),
    ISSUING		(IDs.ISSUING, "issuingTransactions")*/
    ;
	
    private Integer id;
    private String name;


    private TransactionType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public String getLabelResourceId() {
        return "enum.transactionType." + name + ".label";
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
        public static final int UNKNOWN             = -1;
        public static final int RELOAD              = 1;
        public static final int VALIDATION		    = 2;
        
//        TODO: To be defined
//        public static final int INSPECTION     		= 3;
//        public static final int ISSUING             = 4;
    }


}