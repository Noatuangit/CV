package com.java.service.impl;

import com.java.dto.FormDTO;
import com.java.model.Customer;
import com.java.repos.ICustomerRepos;
import com.java.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepos customerRepos;


    @Override
    public List<Customer> findAll() {
        return customerRepos.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepos.findById(id).orElse(null);
    }

    @Override
    public void save(FormDTO dto) {
        customerRepos.save(new Customer(dto));
    }
}
