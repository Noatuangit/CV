package com.java.controller;

import com.java.dto.ServiceBookingDTO;
import com.java.model.AddService;
import com.java.model.Customer;
import com.java.model.ServiceDetails;
import com.java.service.IComputerDetailService;
import com.java.service.ICustomerService;
import com.java.service.IServiceDetailService;
import com.java.service.IServiceService;
import com.java.service.impl.ComputerDetailServiceImpl;
import com.java.service.impl.CustomerServiceImpl;
import com.java.service.impl.ServiceDetailServiceImpl;
import com.java.service.impl.ServiceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("booking")
public class BookingServiceForm {
    IServiceDetailService serviceDetailService;
    ICustomerService customerService;
    IServiceService serviceService;
    IComputerDetailService computerDetailService;

    @ModelAttribute("customers")
    public List<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    @ModelAttribute("services")
    public List<AddService> findAllService() {
        return serviceService.findAll();
    }


    public BookingServiceForm(ServiceDetailServiceImpl serviceDetailService,
                              CustomerServiceImpl service,
                              ComputerDetailServiceImpl computerDetailService,
                              ServiceServiceImpl serviceService) {
        this.serviceDetailService = serviceDetailService;
        this.computerDetailService = computerDetailService;
        this.customerService = service;
        this.serviceService = serviceService;
    }

    @GetMapping("")
    public String goForm(Model model) {
        model.addAttribute("detail", new ServiceBookingDTO());
        return "serviceDetails/form";
    }

    @PostMapping("")
    public String saveEntity(@Validated @ModelAttribute("detail") ServiceBookingDTO serviceBookingDTO, BindingResult bindingResult) {
       serviceBookingDTO.validate(serviceBookingDTO, bindingResult);
        if (bindingResult.hasErrors()) {
             return "serviceDetails/form";
        }
        serviceDetailService.save(new ServiceDetails(serviceBookingDTO));
        return "redirect:/managerService";
    }

    @PostMapping("/delete")
    public String deleteEntity(){
        return "redirect:/managerComputer";
    }

}
