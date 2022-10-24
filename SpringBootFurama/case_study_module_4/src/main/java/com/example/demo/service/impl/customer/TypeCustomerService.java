package com.example.demo.service.impl.customer;

import com.example.demo.models.customer.CustomerType;
import com.example.demo.repos.customer.ITypeCustomerRepository;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerService implements ITypeService<CustomerType> {
    @Autowired
    ITypeCustomerRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return repository.findAll();
    }
}
