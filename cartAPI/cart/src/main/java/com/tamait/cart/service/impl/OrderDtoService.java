package com.tamait.cart.service.impl;

import com.tamait.cart.dto.OrderDTO;
import com.tamait.cart.repository.IOrderDtoRepository;
import com.tamait.cart.service.IOrderDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDtoService implements IOrderDtoService {
    @Autowired
    IOrderDtoRepository repository;

    @Override
    public Iterable<OrderDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        return repository.save(orderDTO);
    }
}
