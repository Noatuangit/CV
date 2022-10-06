package com.tamait.cart.repository;

import com.tamait.cart.models.Order;
import com.tamait.cart.models.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<ShopCart, Integer> {
}
