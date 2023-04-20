package com.java.controller;

import com.java.dto.OrderDTO;
import com.java.dto.ViewDTO;
import com.java.model.Customer;
import com.java.model.Details;
import com.java.model.Order;
import com.java.service.ITypeService;
import com.java.service.impl.CustomerService;
import com.java.service.impl.DetailsService;
import com.java.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class MainController {
    ITypeService<Customer> customerITypeService;
    ITypeService<Order> orderITypeService;
    ITypeService<Details> detailsITypeService;

    public MainController(CustomerService customerITypeService, OrderService orderITypeService, DetailsService detailsService) {
        this.customerITypeService = customerITypeService;
        this.orderITypeService = orderITypeService;
        this.detailsITypeService = detailsService;
    }

    @GetMapping("")
    public String getHome(@RequestParam(value = "n", defaultValue = "") String date, Model model) {
        model.addAttribute("data", orderITypeService.findAll(date).stream().map(ViewDTO::new).collect(Collectors.toList()));
        return "home";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("item", new OrderDTO());
        model.addAttribute("action", "create");
        return "form";
    }

    @PostMapping("/create")
    public String createEntity(@Valid @ModelAttribute("item") OrderDTO dto, BindingResult result, Model model) {
        new OrderDTO().validate(dto, result);
        if (result.hasErrors()) {
            model.addAttribute("action", "create");
            return "form";
        }
        Order order = orderITypeService.save(new Order(dto));
        detailsITypeService.save(new Details(order, dto));
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable("id") String id, Model model) {
        Order order = orderITypeService.findById(id);
        model.addAttribute("item", new OrderDTO(order));
        model.addAttribute("action", "update");
        return "form";
    }

    @PostMapping("/update")
    public String saveEdit(@Valid @ModelAttribute ("item") OrderDTO dto, BindingResult result, Model model){
        new OrderDTO().validate(dto, result);
        if (result.hasErrors()) {
            model.addAttribute("action", "update");
            return "form";
        }
        Order order = orderITypeService.save(new Order(dto));
        detailsITypeService.save(new Details(order, dto));
        return "redirect:/";
    }
}
