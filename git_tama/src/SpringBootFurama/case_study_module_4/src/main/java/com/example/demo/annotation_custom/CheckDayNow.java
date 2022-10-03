package com.example.demo.annotation_custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;
import java.time.LocalDate;

public class CheckDayNow implements ConstraintValidator<DayMustBiggerNow, Date> {
    @Override
    public void initialize(DayMustBiggerNow constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value.toString().isEmpty()) return false;
        return LocalDate.parse(value.toString()).isAfter(LocalDate.now());
    }
}
