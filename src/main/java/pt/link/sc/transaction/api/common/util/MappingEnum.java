package pt.link.sc.transaction.api.common.util;

import java.io.Serializable;

/**
 * @author mario.macarico
 */
public interface MappingEnum<T extends Enum<?>> extends Serializable {

    /**
     * Get the mapping object
     */
    T getMappingObject();

}