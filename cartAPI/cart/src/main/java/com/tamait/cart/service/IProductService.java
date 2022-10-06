package com.tamait.cart.service;

import com.tamait.cart.models.Product;

public interface IProductService {
    Iterable<Product> findAll();

}
