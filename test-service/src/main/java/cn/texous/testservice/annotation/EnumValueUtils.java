package cn.texous.testservice.annotation;

import org.assertj.core.util.Strings;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

/**
 * 自定义枚举值校验类
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueUtils.Validator.class)
public @interface EnumValueUtils {

    String message() default "{custom.value.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> enumClass();

    String enumMethod();

    class Validator implements ConstraintValidator<EnumValueUtils, Object> {

        private Class<? extends Enum<?>> enumClass;
        private String enumMethod;

        @Override
        public void initialize(EnumValueUtils enumValue) {
            enumMethod = enumValue.enumMethod();
            enumClass = enumValue.enumClass();
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
            if (value == null) {
                return Boolean.TRUE;
            }

            if (enumClass == null || enumMethod == null) {
                return Boolean.TRUE;
            }

            Class<?> valueClass = value.getClass();

            try {
                Method method = enumClass.getMethod(enumMethod, valueClass);
                of(method).map(Method::getReturnType)
                        .filter(t->Boolean.TYPE.equals(t)||Boolean.class.equals(t))
                        .orElseThrow(()->new RuntimeException(Strings.formatIfArgs("%s method return is not boolean type in the %s class", enumMethod, enumClass)));

                of(method).map(Method::getModifiers)
                        .filter(m->Modifier.isStatic(method.getModifiers()))
                        .orElseThrow(()->new RuntimeException(Strings.formatIfArgs("%s method is not static method in the %s class", enumMethod, enumClass)));

                return ofNullable(method.invoke(null,value)).map(result->Boolean.valueOf(result.toString())).orElse(Boolean.FALSE);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException | SecurityException e) {
                throw new RuntimeException(Strings.formatIfArgs("This %s(%s) method does not exist in the %s", enumMethod, valueClass, enumClass), e);
            }
        }

    }
}