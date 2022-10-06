package com.example.demo.annotation_custom;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;


@Documented
@Constraint(validatedBy = ValidBigger18.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDayBirthBigger18 {
    String message() default "age must bigger 18+";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

