package com.java.utils;

import com.java.model.Customer;
import com.java.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationCustomerIdExists implements ConstraintValidator<ValidCustomerExists, String> {
    @Autowired
    ITypeService<Customer> service;

    @Override
    public void initialize(ValidCustomerExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return service.findById(value) != null;
    }
}
