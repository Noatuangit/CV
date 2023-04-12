package com.example.demo.service.interface_business;

import com.example.demo.models.employee.roles.EmployeeAccount;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IEmployeeAccountService {
    Optional<EmployeeAccount> findByUserNameAndPassword(String username , String password);
}
