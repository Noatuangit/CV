package com.example.demo.service.impl.customer;

import com.example.demo.models.customer.Customer;
import com.example.demo.repos.customer.ICustomerRepository;
import com.example.demo.service.interface_business.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllByName(String name_search, Pageable pageable) {
        return customerRepository.findAllByName(name_search, pageable);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateById(Integer id_delete) {
        customerRepository.updateById(id_delete);
    }

    @Override
    public void updateMoneyById(Integer id) {

    }

}
