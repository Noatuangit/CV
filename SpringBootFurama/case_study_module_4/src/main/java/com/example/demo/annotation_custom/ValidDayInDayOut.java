package com.example.demo.annotation_custom;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class ValidDayInDayOut implements ConstraintValidator<ValidDifferenceDay, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(ValidDifferenceDay constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(fieldMatch);

        return ChronoUnit.MONTHS.between(
                YearMonth.from(LocalDate.parse(fieldValue.toString())),
                YearMonth.from(LocalDate.parse(fieldMatchValue.toString()))) > 6;
    }

}
