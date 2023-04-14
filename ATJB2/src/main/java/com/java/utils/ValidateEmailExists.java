package com.java.utils;

import com.java.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateEmailExists implements ConstraintValidator<EmailNotExists, String> {
    @Autowired
    CustomerServiceImpl service;

    @Override
    public void initialize(EmailNotExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if("".equals(value)) return true;
        return !service.findByEmail(value).isPresent();
    }
}
