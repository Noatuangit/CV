package com.tamait.cart.service.impl;

import com.tamait.cart.models.Order;
import com.tamait.cart.models.ShopCart;
import com.tamait.cart.repository.ICartRepository;
import com.tamait.cart.service.ICartService;
import com.tamait.cart.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository repository;


    @Autowired
    IOrderService service;

    @Override
    public void save(List<ShopCart> list) {
        Integer idOrder = service.findByLast().get().getId();
        for (ShopCart shopCart : list) {
            repository.save(idOrder, shopCart.getProduct().getId(), shopCart.getQuantity(), shopCart.getMoney());
        }
    }
}
