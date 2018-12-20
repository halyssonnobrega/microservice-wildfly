package pt.link.sc.transaction.api.common.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * From SDS Project Interface for generic enums with a key (id) and a name for
 * each element.
 *
 * @param <K> the type of the id field (key)
 * @author jose.damaso
 * @author mario.macarico
 */
public interface PersistentEnum<K extends Comparable<K>> extends Serializable, Labeled {

    /**
     * Get the id for this enum element
     */
    K getId();

    /**
     * Get the name for this enum element
     */
    String getName();

    default boolean in(Object... values) {
        return Arrays.stream(values).anyMatch(v -> Objects.equals(this, v));
    }

    default boolean in(Collection<? extends PersistentEnum<K>> values) {
        return inCollection(values);
    }

    default boolean inCollection(Collection<? extends PersistentEnum<K>> values) {
        return values.contains(this);
    }


    default K order() {
        return getId();
    }
}