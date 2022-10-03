package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Aspect
@Configuration
public class LogController {

    Logger logger = LoggerFactory.getLogger(LogController.class);

    @After("execution(* com.example.demo.controller.CustomerController.editCustomer(..)) && args (id,..)")
    public void checkId(JoinPoint joinPoint, Integer id) {
        System.out.println("get parameter " + id);
        LocalDate startTime = LocalDate.now();
        logger.info("Start Time Taken by {} is {}", joinPoint, startTime);
    }
}
