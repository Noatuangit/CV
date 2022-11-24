package com.example.demo.controller;

import com.example.demo.DTO.HouseHoldDTO;
import com.example.demo.models.HouseHold;
import com.example.demo.service.IHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    final int MAX_DISPLAY = 5;
    @Autowired
    IHouseHoldService service;

     @GetMapping("")
    public String goHome(Model model,
                         @RequestParam(defaultValue = "") String name_search,
                         @RequestParam(defaultValue = "") String address_search,
                         @RequestParam(defaultValue = "") String date_search,
                         @PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<HouseHold> houseHolds = service.findAll(name_search, address_search,date_search, pageable);
        List<HouseHoldDTO> dtoList = new ArrayList<>();
        houseHolds.forEach(x -> dtoList.add(new HouseHoldDTO(x)));
        model.addAttribute("list", dtoList);
        model.addAttribute("name_search", name_search);
        model.addAttribute("address_search", address_search);
        model.addAttribute("date_search", date_search);
        model.addAttribute("totalPages", houseHolds.getTotalPages());
        return "home";
    }
}
