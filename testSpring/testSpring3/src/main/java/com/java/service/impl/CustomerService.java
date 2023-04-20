package com.java.service.impl;

import com.java.model.Customer;
import com.java.repos.ICustomerRepos;
import com.java.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ITypeService<Customer> {
    @Autowired
    ICustomerRepos customerRepos;

    @Override
    public List<Customer> findAll(String status) {
        return customerRepos.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepos.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepos.findById(id).orElse(null);
    }
}
