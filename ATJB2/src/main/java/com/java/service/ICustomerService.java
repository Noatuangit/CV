package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.model.Customer;

@Service
public interface ICustomerService {
    List<Customer> findAllByNameAndPhone(String name, String phone,String sort, Integer page);

    long countQuery(String name, String phone);

    void save(Customer customer);

    Optional<Customer> findByEmail(String email);

    Integer removeById(String id);

    Customer findById(String id);

    void edit(Customer customer, String id);

    List<Customer> findAll();

    void updateStatusById(String id);
}
