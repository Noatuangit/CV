package com.java.service.impl;

import com.java.model.Order;
import com.java.repos.IOrdersRepos;
import com.java.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService implements ITypeService<Order> {

    @Autowired
    IOrdersRepos ordersRepos;

    @Override
    public List<Order> findAll(String date) {
        if ("".equalsIgnoreCase(date)) return ordersRepos.findAll();
        return ordersRepos.findAllByStatusOrderAndDateEndBefore("chua giao hang", Date.valueOf(date));
    }

    @Override
    public Order save(Order order) {
        return ordersRepos.save(order);
    }

    @Override
    public Order findById(String id) {
        return ordersRepos.findById(id).orElse(null);
    }
}
