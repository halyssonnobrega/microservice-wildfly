package pt.link.sc.transaction.api.common.enums;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;

import pt.link.sc.transaction.api.common.util.PersistentEnum;

public enum ReloadTransactionType implements PersistentEnum<Integer> {
    UNKNOWN		(IDs.UNKNOWN, 	"unknown"),
    VEND		(IDs.VEND,  	"sell"),
    CARR		(IDs.CARR, 		"load"),
    VEND_CARR	(IDs.VEND_CARR, "sellNload"),
    ANUL_VEND	(IDs.ANUL_VEND, "sellAnnulment"),
    ANUL_CARR	(IDs.ANUL_CARR, "loadAnnulment"),
    ANUL_VEND_CARR(IDs.ANUL_VEND_CARR, "sellNloadAnnulment"),
    ANUL_RESTIT	(IDs.ANUL_RESTIT, "restoreAnnulment"),
    ANUL_TRANSF	(IDs.ANUL_TRANSF, "transferAnnulment"),
    RESTIT		(IDs.RESTIT, 	"restore"),
    TRANSF		(IDs.TRANSF, 	"transfer"),
	CORREC		(IDs.CORREC, 	"correction");
	
    private Integer id;
    private String name;


    private ReloadTransactionType(Integer id, String name) {
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
        public static final int VEND                = 1;
        public static final int CARR		        = 2;
        public static final int VEND_CARR     		= 3;
        public static final int ANUL_VEND               = 4;
        public static final int ANUL_CARR             	= 5;
        public static final int ANUL_VEND_CARR          = 6;
        public static final int RESTIT               	= 10;
        public static final int TRANSF               	= 11;
        public static final int ANUL_RESTIT 			= 15;
        public static final int ANUL_TRANSF            	= 16;
        public static final int CORREC               	= 17;
    }


}