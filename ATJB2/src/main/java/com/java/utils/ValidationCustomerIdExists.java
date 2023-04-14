package com.java.utils;

import com.java.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationCustomerIdExists implements ConstraintValidator<CustomerIdExists, String> {
    @Autowired
    ICustomerService customerService;

    @Override
    public void initialize(CustomerIdExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("".equals(value)) return true;
        return customerService.findById(value) != null;
    }
}
