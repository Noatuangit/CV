package com.java.utils;

import com.java.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateIdBuilding implements ConstraintValidator<ValidBuilding, String> {
    @Autowired
    IBuildingService buildingService;

    @Override
    public void initialize(ValidBuilding constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("".equalsIgnoreCase(value)) return true;
        return buildingService.findById(value).isPresent();
    }
}
