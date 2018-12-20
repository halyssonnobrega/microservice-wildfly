package pt.link.sc.transaction.api.common.validationGroups;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;



/**
 * Implementation of {@link PositiveIfAnotherFieldHasValue} validator.
 **/
public class PositiveIfAnotherFieldHasValueValidator implements ConstraintValidator<PositiveIfAnotherFieldHasValue, Object> {

    private String fieldName;
    private Object expectedFieldValue;
    private String dependFieldName;

    @Override
    public void initialize(PositiveIfAnotherFieldHasValue annotation) {
        fieldName = annotation.fieldName();
        expectedFieldValue = annotation.fieldValue();
        dependFieldName = annotation.dependFieldName();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext ctx) {

        if (value == null) {
            return true;
        }

        try {
            Object fieldValue = PropertyUtils.getProperty(value, fieldName);
            Object dependFieldValue = PropertyUtils.getProperty(value, dependFieldName);

            if (expectedFieldValue.equals(fieldValue) &&
                    (dependFieldValue == null || (dependFieldValue instanceof Long && (Long) dependFieldValue < 0))) {
                ctx.disableDefaultConstraintViolation();
                ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate()).addNode(dependFieldName).addConstraintViolation();
                return false;
            }

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        return true;
    }

}