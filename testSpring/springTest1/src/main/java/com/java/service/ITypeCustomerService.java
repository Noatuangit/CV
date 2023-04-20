package com.java.service;

import com.java.model.TypeCustomer;

import java.util.List;
import java.util.Optional;

public interface ITypeCustomerService {
    List<TypeCustomer> findAll();
    Optional<TypeCustomer> findById(String id);
}
