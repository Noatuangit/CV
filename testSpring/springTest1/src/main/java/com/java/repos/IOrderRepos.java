package com.java.repos;

import com.java.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrderRepos extends JpaRepository<Order, String> {
       Page<Order> findAllByNameContaining(  String name, Pageable pageable);
}
