package com.tamait.cart.service.impl;

import com.tamait.cart.models.Product;
import com.tamait.cart.repository.IProductRepository;
import com.tamait.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
