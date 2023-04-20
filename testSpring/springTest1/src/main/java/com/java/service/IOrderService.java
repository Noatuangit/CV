package com.java.service;

import com.java.dto.OrderDTO;
import com.java.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Page<Order> findAll(String name, Pageable pageable);

    Order save(ITypeCustomerService service,OrderDTO order);

    Order findById(String id);
}
