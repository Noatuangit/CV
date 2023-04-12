package com.tuanln6.utils;

import com.tuanln6.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationComputerIdExists  implements ConstraintValidator<ComputerIdExists, String> {
    @Autowired
    IComputerService computerService;

    @Override
    public void initialize(ComputerIdExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("".equals(value)) return true;
        return computerService.findById(value) != null;
    }
}
