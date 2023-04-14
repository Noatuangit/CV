package com.java.controller;

import com.java.service.IComputerDetailService;
import com.java.service.IServiceDetailService;
import com.java.service.impl.ComputerDetailServiceImpl;
import com.java.service.impl.ServiceDetailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
    IComputerDetailService computerDetailService;
    IServiceDetailService serviceDetailService;

    public MainController(ComputerDetailServiceImpl service, ServiceDetailServiceImpl serviceDetailService) {
        this.computerDetailService = service;
        this.serviceDetailService = serviceDetailService;
    }

    @GetMapping("")
    public String goCustomer() {
        return "home";
    }

    @GetMapping("managerComputer")
    public String displayBookingComputer(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            Model model) {
        model.addAttribute("details", computerDetailService.findAll(page));
        model.addAttribute("totalPages", computerDetailService.countQuery());
        model.addAttribute("page", page);
        return "computerDetails/managerDetails";
    }

    @GetMapping("managerService")
    public String displayBookingService(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                        Model model) {
        model.addAttribute("services", serviceDetailService.findAll(page));
        model.addAttribute("totalPages", serviceDetailService.countQuery());
        model.addAttribute("page", page);
        return "serviceDetails/managerDetails";
    }

    @GetMapping("managerTotal")
    public String displayTotalService(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        model.addAttribute("totals", computerDetailService.findAllServicePresent(page));
        model.addAttribute("page", page);
        model.addAttribute("totalsPage", computerDetailService.countTotalService());
        return "managerTotal/managerTotal";
    }
}
