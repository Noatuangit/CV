package com.tuanln6.utils;

import com.tuanln6.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateEmailExists implements ConstraintValidator<EmailExists, String> {
    @Autowired
    ICustomerService service;
    @Override
    public void initialize(EmailExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if("".equals(value)) return true;
        return !service.findByEmail(value).isPresent();
    }
}
