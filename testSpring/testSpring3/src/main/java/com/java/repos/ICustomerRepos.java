package com.java.repos;

import com.java.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepos extends JpaRepository<Customer , String> {
}
