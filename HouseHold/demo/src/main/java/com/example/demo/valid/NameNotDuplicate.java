package com.example.demo.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

@Documented
@Constraint(validatedBy = ValidNameNotDuplicate.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameNotDuplicate {
    String message() default "name not duplicate";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
