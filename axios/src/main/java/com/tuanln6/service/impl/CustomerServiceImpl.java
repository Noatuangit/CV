package com.tuanln6.service.impl;

import com.tuanln6.dto.customer.CustomerDTO;
import com.tuanln6.dto.customer.CustomerEditDTO;
import com.tuanln6.error.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tuanln6.model.Customer;
import com.tuanln6.repos.ICustomerRepos;
import com.tuanln6.service.ICustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepos customerRepos;

    @Override
    public Page<Customer> findAllByConditionAndStatusOn(String condition, Pageable pageable) {
        return customerRepos.findAllByStatusAndNameContainingOrAddressContainingOrEmailContainingOrderByName("on", condition, condition, condition, pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepos.findAllByStatus("on");
    }

    @Override
    public Integer updateStatusById(String id) {
        return customerRepos.updateStatusById(id);
    }

    @Override
    public Customer save(CustomerDTO customerDTO) {
        return customerRepos.save(new Customer(customerDTO));
    }

    @Override
    public Optional<Customer> findByEmail(String value) {
        return customerRepos.findByEmail(value);
    }

    @Override
    public Customer findById(String id) {
        Optional<Customer> customer = customerRepos.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        throw new NotFoundException("Server not found customer with id " + id);
    }

    @Override
    public Customer update(CustomerEditDTO dto) {
        return customerRepos.save(new Customer(dto));
    }


}
