package com.java.repos;

import java.util.List;
import java.util.Optional;

import com.java.model.Customer;

public interface ICustomerRepos {
    List<Customer> findAllByNameAndPhone(String name, String phone, String sort, Integer page);

    void save(Customer customer);

    long countQuery(String name, String phone);

    Integer removeById(String id);

    Customer findById(String id);

    void edit(Customer customer);

    Optional<Customer> findByEmail(String email);

    List<Customer> findAll();

    void updateStatusById(String id);
}
