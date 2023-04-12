package com.tuanln6.aspect;

import com.tuanln6.dto.details.ComputerDetailsDTO;
import com.tuanln6.dto.view.ComputerViewDetailsDTO;
import com.tuanln6.service.IComputerDetailsService;
import com.tuanln6.service.IComputerService;
import com.tuanln6.service.IServiceDetailsService;
import com.tuanln6.service.impl.ComputerDetailsServiceImpl;
import com.tuanln6.service.impl.ComputerServiceImpl;
import com.tuanln6.service.impl.ServiceDetailsServiceImpl;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ControllerPointCutApi {

    IComputerService computerService;
    IComputerDetailsService computerDetailsService;
    IServiceDetailsService serviceDetailsService;

    public ControllerPointCutApi(ComputerServiceImpl computerService,
                                 ComputerDetailsServiceImpl computerDetailsService,
                                 ServiceDetailsServiceImpl serviceDetailsService) {
        this.computerService = computerService;
        this.computerDetailsService = computerDetailsService;
        this.serviceDetailsService = serviceDetailsService;
    }

    @After("execution( *  com.tuanln6.rest.ComputerDetailsRest.saveComputer(..)) && args(computerDetailsDTO, ..)")
    public void updateComputerAfterBooking(ComputerDetailsDTO computerDetailsDTO) {
        computerService.updateStatusById("waiting", computerDetailsDTO.getComputerId());
    }

    @After("execution( *  com.tuanln6.rest.ComputerDetailsRest.deleteById(..)) && args(computerViewDetailsDTO, ..)")
    public void updateComputerAfterDelete(ComputerViewDetailsDTO computerViewDetailsDTO) {
        computerService.updateStatusById("on", computerViewDetailsDTO.getComputerId());
    }

    @Before("execution(* com.tuanln6.rest.CustomerRest.updateStatusById(..)) && args(id,..)")
    public void updateCustomerDetailsBeforeDeleteCustomer(String id) {
        computerDetailsService.removeByCustomerId(id);
        serviceDetailsService.removeByCustomerId(id);
    }

    @Before("execution(* com.tuanln6.rest.ComputerRest.updateStatusById(..)) && args(id,..)")
    public void updateComputerDetailsBeforeDeleteComputer(String id) {
        computerDetailsService.removeByComputerId(id);
    }

    @Before("execution(* com.tuanln6.rest.ServiceRest.updateStatusById(..)) && args(id,..)")
    public void updateServiceDetailsBeforeDeleteService(String id) {
        serviceDetailsService.removeByServiceId(id);
    }
}
