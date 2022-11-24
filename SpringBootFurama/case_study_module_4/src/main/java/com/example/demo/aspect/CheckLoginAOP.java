package com.example.demo.aspect;

import com.example.demo.error.exception.NotFoundEmployee;
import com.example.demo.error.exception.NotPermission;
import com.example.demo.models.employee.roles.EmployeeAccount;
import com.example.demo.service.interface_business.IEmployeeAccountService;
import lombok.SneakyThrows;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Aspect
@Configuration
public class CheckLoginAOP {
    @Autowired
    IEmployeeAccountService employeeAccountService;

    @Autowired
    HttpServletRequest request;

    List<String> list = new ArrayList<>(Arrays.asList("President", "Manager"));

    Logger logger = LoggerFactory.getLogger(CheckLoginAOP.class);


    @SneakyThrows
    @Before("execution(* com.example.demo.controller.HomeController.loginEmployee(..)) && args (account,..)")
    public void checkCorrectAccount(EmployeeAccount account) {
        Optional<EmployeeAccount> optionalEmployeeAccount = employeeAccountService.findByUserNameAndPassword(account.getUsername(), account.getPassword());
        if (!optionalEmployeeAccount.isPresent()) {
            throw new NotFoundEmployee("Not found employee have this account. Try Again!!!");
        }
    }


    @SneakyThrows
    @Before("execution(* com.example.demo.controller.EmployeeController.*(..))")
    public void checkAuthentication() {
        Cookie[] cookie = request.getCookies();
        for (Cookie c : cookie) {
            if (list.contains(c.getValue())) {
                return;
            }
        }
        throw new NotPermission("You not permission to edit employee");
    }
}
