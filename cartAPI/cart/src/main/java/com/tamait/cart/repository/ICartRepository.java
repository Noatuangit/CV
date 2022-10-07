package com.tamait.cart.repository;

import com.tamait.cart.models.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICartRepository extends JpaRepository<ShopCart, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into shopcart (orders_id,product_id,quantity,money) values (?1,?2,?3,?4)", nativeQuery = true)
    void save(Integer idOrder, Integer product, Integer quantity, Integer money);
}
