package pt.link.sc.transaction.api.common.enums;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import pt.link.sc.transaction.api.common.util.MappingEnum;
import pt.link.sc.transaction.api.common.util.PersistentEnum;

public class EnumUtil {

    private EnumUtil() {

    }

    public static <K extends Comparable<K>, T extends PersistentEnum<K>> Optional<T> getById(K id, Class<T> clazz) {
        if (id == null) {
            return Optional.empty();
        }
        for (T enumValue : clazz.getEnumConstants()) {
            if (enumValue.getId().equals(id))
                return Optional.of(enumValue);
        }
        return Optional.empty();
    }

    public static <K extends Comparable<K>, T extends PersistentEnum<K>> K getEnumId(T persistentEnum) {
        if (persistentEnum == null) {
            return null;
        }
        return persistentEnum.getId();
    }

    public static <K extends Comparable<K>, T extends PersistentEnum<K>> Optional<T> getByName(String value, Class<T> clazz) {
        if (StringUtils.isBlank(value)) {
            return Optional.empty();
        }
        for (T enumValue : clazz.getEnumConstants()) {
            if (enumValue.getName().toUpperCase().equals(value.toUpperCase()))
                return Optional.of(enumValue);
        }
        return Optional.empty();

    }

    public static <T extends Enum<?>> Optional<T> getMappingObject(MappingEnum<T> enumObject) {
        if (enumObject != null) {
            return Optional.of(enumObject.getMappingObject());
        }
        return Optional.empty();
    }

    public static <T extends Enum<?>, K extends MappingEnum<T>> K fromMappingRelation(Class<K> enumType, T mapping) {
        for (K b : enumType.getEnumConstants()) {
            if (b.getMappingObject().equals(mapping)) {
                return b;
            }
        }
        return null;
    }
}
