package com.tamait.cart.service.impl;

import com.tamait.cart.models.Customer;
import com.tamait.cart.models.Order;
import com.tamait.cart.repository.IOrderRepository;
import com.tamait.cart.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository repository;

    @Override
    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Order> findByLast() {
        return repository.findByLast() ;
    }

    @Override
    public void createOrder(Customer customer) {
         repository.saveByIdCustomer(customer.getId());
    }
}
