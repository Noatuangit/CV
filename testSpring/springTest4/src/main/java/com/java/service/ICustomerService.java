package com.java.service;

import com.java.dto.FormDTO;
import com.java.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(String id);

    void save(FormDTO dto);
}
