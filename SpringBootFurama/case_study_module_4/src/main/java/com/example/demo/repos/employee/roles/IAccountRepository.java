package com.example.demo.repos.employee.roles;

import com.example.demo.models.employee.roles.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<EmployeeAccount,Integer> {
    Optional<EmployeeAccount> findAllByUsernameContainingAndPasswordContaining(String username , String password);
}
