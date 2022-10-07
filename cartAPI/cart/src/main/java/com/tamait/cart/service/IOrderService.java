package com.tamait.cart.service;

import com.tamait.cart.models.Customer;
import com.tamait.cart.models.Order;

import java.util.Optional;

public interface IOrderService {
    Iterable<Order> findAll();

    Optional<Order> findById(Integer id);

    Optional<Order> findByLast();

    void createOrder(Customer customer);
}
