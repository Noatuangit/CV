package com.tuanln6.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

@Documented
@Constraint(validatedBy = ValidationComputerIdExists.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ComputerIdExists {
    String message() default "computer is not exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
