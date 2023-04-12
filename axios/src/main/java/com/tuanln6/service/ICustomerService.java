package com.tuanln6.service;

import com.tuanln6.dto.customer.CustomerDTO;
import com.tuanln6.dto.customer.CustomerEditDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tuanln6.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllByConditionAndStatusOn(String condition, Pageable pageable);

    List<Customer> findAll();

    Integer updateStatusById(String id);

    Customer save(CustomerDTO customerDTO);

    Optional<Customer> findByEmail(String value);

    Customer findById(String id);

    Customer update(CustomerEditDTO dto);
}
