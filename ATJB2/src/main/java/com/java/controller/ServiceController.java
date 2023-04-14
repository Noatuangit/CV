package com.java.controller;

import com.java.dto.ServiceDTO;
import com.java.model.AddService;
import com.java.service.IServiceService;
import com.java.service.impl.ServiceServiceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {
    IServiceService serviceService;

    public ServiceController(ServiceServiceImpl serviceService) {
        this.serviceService = serviceService;
    }

    @ModelAttribute("units")
    public List<String> getUnitService() {
        return Arrays.asList("Unit", "Place", "Cubic", "Chain", "Bottle");
    }

    @GetMapping("")
    public String goHome(@RequestParam(value = "name", defaultValue = "") String name,
                         @RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        model.addAttribute("services", serviceService.findAllByName(name, page));
        model.addAttribute("pageTotals", serviceService.countFindAllByName(name));
        model.addAttribute("page", page);
        model.addAttribute("name", name);
        return "service/listService";
    }

    @GetMapping("form")
    public String goForm(Model model) {
        model.addAttribute("service", new ServiceDTO());
        return "service/formService";
    }

    @GetMapping("/{id}")
    public String goEditForm(Model model, @PathVariable String id) {
        model.addAttribute("service", serviceService.findById(id));
        return "service/formService";
    }

    @PostMapping("")
    public String updateEntity(@Valid @ModelAttribute("service") ServiceDTO serviceDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "service/formService";
        }

        if (serviceDto.getId() == null) {
            redirectAttributes.addFlashAttribute("message", "create success!!!");
        } else {
            redirectAttributes.addFlashAttribute("message", "update success!!!");
        }
        serviceService.save(new AddService(serviceDto));

        return "redirect:/service";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        serviceService.updateById(id);
        redirectAttributes.addFlashAttribute("message", "Delete success!!!");
        return "redirect:/service";
    }
}
