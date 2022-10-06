package com.tamait.cart.service;

import com.tamait.cart.models.ShopCart;

import java.util.List;

public interface ICartService {
    void save(List<ShopCart> cart);
}
