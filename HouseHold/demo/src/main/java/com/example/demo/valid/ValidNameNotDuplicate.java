package com.example.demo.valid;

import com.example.demo.service.IHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameNotDuplicate implements ConstraintValidator<NameNotDuplicate, String> {
    @Autowired
    IHouseHoldService service;

    @Override
    public void initialize(NameNotDuplicate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return service.findAll("", "", "", Pageable.unpaged()).stream().noneMatch(x -> x.getName().equalsIgnoreCase(value));
    }
}
