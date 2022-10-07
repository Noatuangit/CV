package com.tamait.cart.AOP;

import com.tamait.cart.dto.OrderDTO;
import com.tamait.cart.models.Customer;
import com.tamait.cart.models.ShopCart;
import com.tamait.cart.service.ICustomerService;
import com.tamait.cart.service.IOrderDtoService;
import com.tamait.cart.service.IOrderService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Aspect
@Configuration
public class AOPController {
    @Autowired
    IOrderService iOrderService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IOrderDtoService dtoService;

    Logger logger = LoggerFactory.getLogger(AOPController.class);

    @Before("execution(* com.tamait.cart.controller.RestAPIController.login(..)) && args(customer)")
    public ResponseEntity<Customer> before(Customer customer) {
        Optional<Customer> optionalCustomer = customerService.login(customer);
        logger.info("User {} with email {} logging in {}", customer.getName(), customer.getEmail(), LocalDateTime.now());
        return optionalCustomer.map(x -> new ResponseEntity<>(x, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Before("execution(* com.tamait.cart.controller.RestAPIController.login(..)) && args(customer)")
    public void afterLogin(Customer customer) {
        iOrderService.createOrder(customerService.login(customer).get());
    }

    @AfterReturning("execution(* com.tamait.cart.service.impl.CartService.save(..)) && args(list)")
    public void logBuyingOfCustomer(List<ShopCart> list) {
        Customer customer = iOrderService.findByLast().get().getCustomer();
        Integer idOrder = iOrderService.findByLast().get().getId();
        for (ShopCart cart : list) {
            dtoService.save(new OrderDTO(idOrder,cart.getProduct().getId(), customer.getId()));
        }
    }
}
