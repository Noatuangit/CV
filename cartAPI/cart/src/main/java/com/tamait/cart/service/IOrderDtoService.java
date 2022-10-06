package com.tamait.cart.service;

import com.tamait.cart.dto.OrderDTO;

public interface IOrderDtoService {
    Iterable<OrderDTO> findAll();

    OrderDTO save(OrderDTO orderDTO);
}
