package com.java.service.impl;

import com.java.model.TypeCustomer;
import com.java.repos.ITypeCustomerRepos;
import com.java.service.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeCustomerServiceImpl implements ITypeCustomerService {

    @Autowired
    ITypeCustomerRepos typeCustomerRepos;

    @Override
    public List<TypeCustomer> findAll() {
        return typeCustomerRepos.findAll();
    }

    @Override
    public Optional<TypeCustomer> findById(String id) {
        return typeCustomerRepos.findById(id);
    }
}
