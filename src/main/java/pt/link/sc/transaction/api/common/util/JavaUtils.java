package pt.link.sc.transaction.api.common.util;

import java.util.Optional;
import java.util.function.Supplier;

public class JavaUtils {
    public static <T> Optional<T> resolve(Supplier<T> supplier) {
        try {
            return Optional.ofNullable(supplier.get());
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}
