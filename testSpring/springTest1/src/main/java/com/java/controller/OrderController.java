package com.java.controller;

import com.java.dto.OrderDTO;
import com.java.service.IOrderService;
import com.java.service.ITypeCustomerService;
import com.java.service.impl.OrderServiceImpl;
import com.java.service.impl.TypeCustomerServiceImpl;
import com.java.utils.CustomValid;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class OrderController {
    final int MaxDisplay = 5;
    IOrderService orderService;
    ITypeCustomerService typeCustomerService;

    public OrderController(OrderServiceImpl orderService, TypeCustomerServiceImpl customerService) {
        this.orderService = orderService;
        this.typeCustomerService = customerService;
    }

    @GetMapping("")
    public String goHome(@RequestParam(value = "n", defaultValue = "") String name,
                         @RequestParam(value = "p", defaultValue = "0") Integer page, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("list", orderService.findAll(name.trim(), PageRequest.of(page, MaxDisplay)));
        return "home";
    }

    @GetMapping("create")
    public String goCreateForm(Model model) {
        model.addAttribute("order", new OrderDTO());
        model.addAttribute("action", "create");
        return "form";
    }

    @GetMapping("{id}")
    public String goEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("order", new OrderDTO(orderService.findById(id)));
        model.addAttribute("action", "edit");
        return "form";
    }

    @PostMapping("create")
    public String saveOrder(@Valid @ModelAttribute("order") OrderDTO orderDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("action", "create");
            return "form";
        }
        orderService.save(typeCustomerService, orderDTO);
        redirectAttributes.addFlashAttribute("message", "Tạo mới order thành công.");
        return "redirect:/";
    }

    @PostMapping("edit")
    public String editOrder(@Valid @ModelAttribute("order") OrderDTO orderDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "form";
        }

        if (CustomValid.checkNumberTicket(orderService, orderDTO.getId(), orderDTO.getPersons(), orderDTO.getChildren())) {
            model.addAttribute("message", "Number ticket to smaller in old ticket.");
            model.addAttribute("action", "edit");
            return "form";
        }

        orderService.save(typeCustomerService, orderDTO);
        redirectAttributes.addFlashAttribute("message", "Update thông tin order thành công.");
        return "redirect:/";
    }


}
