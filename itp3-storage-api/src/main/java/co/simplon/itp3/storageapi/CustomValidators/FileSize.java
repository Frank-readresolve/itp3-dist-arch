package co.simplon.itp3.storageapi.CustomValidators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileSizeValidator.class)
@Documented
public @interface FileSize {

    String message() default "Max upload size exceeded. It should be less or equal to 500KB";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    long maxSizeInKB() default 100;

}
