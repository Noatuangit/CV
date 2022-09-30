package com.example.demo.annotation_custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class ValidBigger18 implements ConstraintValidator<ValidDayBirthBigger18, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ChronoUnit.YEARS.between(YearMonth.from(LocalDate.parse(value)), YearMonth.from(LocalDate.now())) > 18;
    }
}
