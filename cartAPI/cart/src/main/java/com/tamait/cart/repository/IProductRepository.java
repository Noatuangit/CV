package com.tamait.cart.repository;

import com.tamait.cart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p order by p.id")
    List<Product> findAll();

}
