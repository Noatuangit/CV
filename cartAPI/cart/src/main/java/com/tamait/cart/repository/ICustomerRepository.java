package com.tamait.cart.repository;

import com.tamait.cart.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.name = :name and c.email = :email")
    Optional<Customer> login(@Param("name") String name, @Param("email") String email);
}
