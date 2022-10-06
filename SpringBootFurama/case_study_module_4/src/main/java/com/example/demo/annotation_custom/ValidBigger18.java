package com.example.demo.annotation_custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class ValidBigger18 implements ConstraintValidator<ValidDayBirthBigger18, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isEmpty()) return false;
        return ChronoUnit.YEARS.between(YearMonth.from(LocalDate.parse(value)), YearMonth.from(LocalDate.now())) > 18;
    }
}
