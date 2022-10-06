package com.tamait.cart.repository;

import com.tamait.cart.dto.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDtoRepository extends JpaRepository<OrderDTO,Integer> {
}
