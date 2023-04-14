package com.java.controller;


import com.java.dto.CustomerDTO;
import com.java.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.java.service.impl.CustomerServiceImpl;
import com.java.service.ICustomerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    ICustomerService customerService;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

    @GetMapping("")
    public String goIndex(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "sort", defaultValue = "id") String sort,
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            Model model) {
        model.addAttribute("pageTotals", customerService.countQuery(name, phone));
        model.addAttribute("name", name);
        model.addAttribute("sort", sort);
        model.addAttribute("page", page);
        model.addAttribute("phone", phone);
        model.addAttribute("customers", customerService.findAllByNameAndPhone(name, phone, sort, page));
        return "customer/listCustomer";
    }

    @GetMapping("form")
    public String goForm(Model model) {
        model.addAttribute("action", "create");
        model.addAttribute("customer", new Customer());
        return "customer/formCustomer";
    }


    @GetMapping("edit/{id}")
    public String editForm(Model model, @PathVariable String id, RedirectAttributes redirectAttributes) {
        model.addAttribute("action", "update");
        model.addAttribute("customer", customerService.findById(id));
        return "customer/formCustomer";
    }

    @GetMapping("delete")
    public String deleteById(@RequestParam String id, RedirectAttributes redirectAttributes) {
        customerService.updateStatusById(id);
        redirectAttributes.addFlashAttribute("message", "Delete is success!");
        return "redirect:/customer";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("customer") CustomerDTO customerDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("action", "create");
            return "customer/formCustomer";
        }
        customerService.save(new Customer(customerDTO));
        redirectAttributes.addFlashAttribute("message", "Create is success!");
        return "redirect:/customer";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") CustomerDTO customerDTO,
                                 BindingResult result,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        new CustomerDTO().validate(customerDTO, result);
        if (result.hasErrors()) {
            model.addAttribute("action", "update");
            return "customer/formCustomer";
        }
        customerService.edit(new Customer(customerDTO), customerDTO.getId());
        redirectAttributes.addFlashAttribute("message", "Update is success!");
        return "redirect:/customer";
    }
}
