package com.tamait.cart.service;

import com.tamait.cart.models.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> login(Customer customer);

    Optional<Customer> findById(Integer id);
}
