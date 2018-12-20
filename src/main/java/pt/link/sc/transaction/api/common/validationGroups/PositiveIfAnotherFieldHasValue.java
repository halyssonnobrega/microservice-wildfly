package pt.link.sc.transaction.api.common.validationGroups;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Validates that field {@code dependFieldName} is has min value if
 * field {@code fieldName} has value {@code fieldValue}.
 **/
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositiveIfAnotherFieldHasValueValidator.class)
@Documented
public @interface PositiveIfAnotherFieldHasValue {

    String fieldName();

    int fieldValue();

    String dependFieldName();

    String message() default "{PositiveIfAnotherFieldHasValue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        PositiveIfAnotherFieldHasValue[] value();
    }

}