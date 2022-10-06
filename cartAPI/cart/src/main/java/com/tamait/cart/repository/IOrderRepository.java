package com.tamait.cart.repository;

import com.tamait.cart.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o order by o.id")
    List<Order> findAll();

    @Modifying
    @Transactional
    @Query(value = "insert into orders (customer_id) values (:id)", nativeQuery = true)
    void saveByIdCustomer(@Param("id") Integer id);

    @Query(value ="SELECT * FROM orders ORDER BY id DESC limit 1", nativeQuery = true)
    Optional<Order> findByLast();
}
