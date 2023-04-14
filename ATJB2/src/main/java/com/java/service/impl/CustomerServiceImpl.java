package com.java.service.impl;

import java.util.List;
import java.util.Optional;

import com.java.service.ICustomerService;
import org.springframework.stereotype.Service;

import com.java.model.Customer;
import com.java.repos.ICustomerRepos;
import com.java.repos.impl.CustomerReposImpl;

@Service
public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepos repos;

    public CustomerServiceImpl(CustomerReposImpl customerReposImpl) {
        this.repos = customerReposImpl;
    }

    @Override
    public List<Customer> findAllByNameAndPhone(String name, String phone,String sort, Integer page) {
        return repos.findAllByNameAndPhone(name, phone, sort, page);
    }

    @Override
    public long countQuery(String name, String phone) {
        return repos.countQuery(name, phone);
    }

    @Override
    public void save(Customer customer) {
        repos.save(customer);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return repos.findByEmail(email);
    }

    @Override
    public Integer removeById(String id) {
        return repos.removeById(id);
    }

    @Override
    public Customer findById(String id) {
        return repos.findById(id);
    }

    @Override
    public void edit(Customer customer, String id) {
        customer.setId(id);
        repos.edit(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repos.findAll();
    }

    @Override
    public void updateStatusById(String id) {
        repos.updateStatusById(id);
    }

}
