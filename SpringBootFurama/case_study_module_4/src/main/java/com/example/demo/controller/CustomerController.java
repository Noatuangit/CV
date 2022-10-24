package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.models.customer.Customer;
import com.example.demo.models.customer.CustomerType;
import com.example.demo.service.ITypeService;
import com.example.demo.service.interface_business.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    final int MAX_DISPLAY = 4;

    @Autowired
    ICustomerService customerService;

    @Autowired
    ITypeService<CustomerType> typeService;

    @RequestMapping("")
    public String goHomePage(Model model, @RequestParam(defaultValue = "") String name_search,
                         @PageableDefault(size = MAX_DISPLAY, sort = "name", direction = Sort.Direction.ASC)
                                     Pageable pageable) {
        model.addAttribute("list", customerService.findAllByName(name_search, pageable));
        model.addAttribute("name_search", name_search);
        return "customer/index";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", new CustomerDTO(customer.get()));
            model.addAttribute("typeList", typeService.findAll());
            return "customer/form";
        }
        return "redirect:/";
    }

    @RequestMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        model.addAttribute("typeList", typeService.findAll());
        return "customer/form";
    }


    @PostMapping("/update")
    public String createTargetCustomer(@Valid @ModelAttribute("customer") CustomerDTO customerDTO,
                                       BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("typeList", typeService.findAll()    );
            return "customer/form";
        }

        if(customerDTO.getId() == null){
            customerService.save(new Customer(customerDTO));
            attributes.addFlashAttribute("message","Create Success !!!");
        } else {
            Customer customer = new Customer(customerDTO);
            customer.setId(customerDTO.getId());
            customerService.save(customer);
            attributes.addFlashAttribute("message","Edit Success !!!");
        }
        return "redirect:/customer";
    }

    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") Integer id, RedirectAttributes attributes) {
        customerService.updateById(id);
        attributes.addFlashAttribute("message", "Delete Success !!!");
        return "redirect:/customer";
//        Optional<Customer> customer = customerService.findById(id);
//        if (customer.isPresent()) {
//            customer.get().setStatus("off");
//            customerService.save(customer.get());
//        }
//        return goHome(model);
    }
}
