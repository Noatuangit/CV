package com.java.aspect;

 import com.java.service.*;
import com.java.service.impl.*;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

 
@Aspect
@Configuration
public class AspectController {
    IComputerService computerService;
    IServiceService serviceService;
    ICustomerService customerService;
    IComputerDetailService computerDetailService;
    IServiceDetailService serviceDetailService;

    public AspectController(ComputerServiceImpl computerService,
                            ComputerDetailServiceImpl computerDetailService,
                            ServiceDetailServiceImpl serviceDetailService
            , ServiceServiceImpl serviceImpl, CustomerServiceImpl customerServiceImpl) {
        this.computerService = computerService;
        this.serviceService = serviceImpl;
        this.customerService = customerServiceImpl;
        this.computerDetailService = computerDetailService;
        this.serviceDetailService = serviceDetailService;
    }

    @Before("execution( * com.java.controller.CustomerController.deleteById(..)) && args(id, ..)")
    public void beforeDeleteCustomer(String id) {
        computerDetailService.removeByCustomerId(id);
        serviceDetailService.removeByCustomerId(id);
    }

    @Before("execution( * com.java.controller.ComputerController.deleteById(..)) && args(id, ..)")
    public void beforeDeleteComputer(String id) {
        computerDetailService.removeByComputerID(id);
    }

    @Before("execution(* com.java.controller.ServiceController.deleteById(..)) && args(id,..)")
    public void beforeDeleteService(String id) {
        serviceDetailService.removeByServiceId(id);
    }

}
