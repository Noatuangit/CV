package com.java.controller;

import com.java.model.Computer;
import com.java.service.IComputerService;
import com.java.service.impl.ComputerServiceImpl;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/computer")
public class ComputerController {
    IComputerService computerService;

    public ComputerController(ComputerServiceImpl serviceImpl) {
        this.computerService = serviceImpl;
    }

    @GetMapping("")
    public String goHome(@RequestParam(value = "position", defaultValue = "") String position,
                         @RequestParam(value = "status", defaultValue = "") String status,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         Model model) {
        model.addAttribute("pageTotals", computerService.countQuery(position, status));
        model.addAttribute("position", position);
        model.addAttribute("status", status);
        model.addAttribute("page", page);
        model.addAttribute("computers", computerService.findAllByPositionAndStatus(position, status, page));
        return "computer/listComputer";
    }

    @GetMapping("delete")
    public String deleteById(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        computerService.updateStatusById("off", id);
        redirectAttributes.addFlashAttribute("message", "Delete success!!!");
        return "redirect:/computer";
    }

    @PostMapping("")
    public String addComputer(@RequestParam("position") String position,
                              @RequestParam("status") String status,
                              RedirectAttributes redirectAttributes,
                              @RequestParam("id") String id
    ) {
        computerService.save(new Computer(id, position, status));
        if ("".equals(id)) {
            redirectAttributes.addFlashAttribute("message", "create success!!!");
        } else {
            redirectAttributes.addFlashAttribute("message", "update success!!!");
        }
        return "redirect:/computer";
    }
}
