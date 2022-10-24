package com.example.demo.service.interface_business;

import com.example.demo.models.employee.roles.EmployeeAccount;

import java.util.Optional;

public interface IEmployeeAccountService {
    Optional<EmployeeAccount> findByUserNameAndPassword(String username , String password);
}
