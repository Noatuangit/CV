package com.java.repos;

import com.java.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeCustomerRepos extends JpaRepository<TypeCustomer,String> {
}
