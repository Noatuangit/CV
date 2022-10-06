package com.tamait.cart.service.impl;

import com.tamait.cart.models.Customer;
import com.tamait.cart.repository.ICustomerRepository;
import com.tamait.cart.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository repository;

    @Override
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> login(Customer customer) {
        return repository.login(customer.getName(), customer.getEmail());
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return repository.findById(id);
    }
}
