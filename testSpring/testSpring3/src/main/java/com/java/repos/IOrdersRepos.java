package com.java.repos;

import com.java.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface IOrdersRepos extends JpaRepository<Order, String > {
    List<Order> findAllByStatusOrderAndDateEndBefore(String statusOrder, Date dateEnd);
}
