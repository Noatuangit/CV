package com.java.controller;

import com.java.dto.FormDTO;
import com.java.service.ICustomerService;
import com.java.service.ITicketService;
import com.java.service.impl.CustomerServiceImpl;
import com.java.service.impl.TicketServiceImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    ITicketService ticketService;
    ICustomerService customerService;

    public MainController(TicketServiceImpl ticketService, CustomerServiceImpl customerService) {
        this.customerService = customerService;
        this.ticketService = ticketService;
    }

    @ModelAttribute("statusList")
    public List<String> getStatusList() {
        return Arrays.asList("Chua tiem chung", "Da tiem chung it nhat 1 mui");
    }

    @GetMapping("")
    public String goHome(@RequestParam(name = "s", defaultValue = "") String status,
                         @RequestParam(name = "r", defaultValue = "") String result,
                         Model model) {
        model.addAttribute("items", ticketService.findAllByCondition(status, result));
        return "index";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model) {
        model.addAttribute("item", new FormDTO());
        model.addAttribute("action", "create");
        return "form";
    }

    @PostMapping("/create")
    public String createEntity(@Valid @ModelAttribute("item") FormDTO dto,
                               BindingResult result,
                               RedirectAttributes attributes,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "create");
            return "form";
        }
        customerService.save(dto);
        ticketService.save(dto);
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String editById(@PathVariable("id") String id, Model model) {
        model.addAttribute("item", new FormDTO(ticketService.findById(id)));
        model.addAttribute("action", "update");
        return "form";
    }

    @PostMapping("/update")
    public String editEntity(@Valid @ModelAttribute("item") FormDTO dto,
                             BindingResult result,
                             RedirectAttributes attributes,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "update");
            return "form";
        }
        customerService.save(dto);
        return "redirect:/";
    }
} 
