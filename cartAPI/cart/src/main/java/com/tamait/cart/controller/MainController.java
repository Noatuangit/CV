package com.tamait.cart.controller;

import com.tamait.cart.service.ICustomerService;
import com.tamait.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public String goCart(Model model) {
        model.addAttribute("listProduct",iProductService.findAll());
        return "cart";
    }
}
