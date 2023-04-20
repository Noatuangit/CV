package com.java.utils;

import com.java.service.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationTypeCustomerIdExists implements ConstraintValidator<ValidTypeExists, String> {
    @Autowired
    ITypeCustomerService service;
    @Override
    public void initialize(ValidTypeExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if("".equalsIgnoreCase(value)) return true;
        return  service.findById(value).isPresent();
    }
}
