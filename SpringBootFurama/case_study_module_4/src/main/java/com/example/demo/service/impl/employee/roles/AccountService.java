package com.example.demo.service.impl.employee.roles;

import com.example.demo.models.employee.roles.EmployeeAccount;
import com.example.demo.repos.employee.roles.IAccountRepository;
import com.example.demo.service.interface_business.IEmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IEmployeeAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public Optional<EmployeeAccount> findByUserNameAndPassword(String username, String password) {
        return accountRepository.findAllByUsernameContainingAndPasswordContaining(username, password);
    }
}
