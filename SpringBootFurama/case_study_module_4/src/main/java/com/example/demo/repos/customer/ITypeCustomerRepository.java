package com.example.demo.repos.customer;

import com.example.demo.models.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeCustomerRepository extends JpaRepository<CustomerType, Integer> {
}
