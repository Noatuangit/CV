package com.java.controller;

import com.java.dto.BillDTO;
import com.java.model.Bill;
import com.java.model.Building;
import com.java.service.IBillService;
import com.java.service.IBuildingService;
import com.java.service.impl.BillServiceImpl;
import com.java.service.impl.BuildingServiceImpl;
import com.java.utils.CustomValid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
public class BuildingController {
    IBuildingService buildingService;

    IBillService billService;

    public BuildingController(BuildingServiceImpl buildingService, BillServiceImpl billService) {
        this.billService = billService;
        this.buildingService = buildingService;
    }

    @ModelAttribute("types")
    private List<Building> findAll() {
        return buildingService.findAll();
    }

    @GetMapping("")
    public String goHome(
            @RequestParam(name = "n", defaultValue = "") String name,
            @RequestParam(name = "id", defaultValue = "") String id,
            Model model) {
        model.addAttribute("list", billService.findAll(name, id));
        return "home";
    }

    @GetMapping("create")
    public String goCreateForm(Model model) {
        model.addAttribute("bill", new BillDTO());
        model.addAttribute("action", "create");
        return "form";
    }

    @GetMapping("{id}")
    public String goEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("bill", new BillDTO(billService.findById(id)));
        model.addAttribute("action", "edit");
        return "form";
    }

    @PostMapping("create")
    public String createEntity(@Valid @ModelAttribute("bill") BillDTO billDTO,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        new BillDTO().validate(billDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("action", "create");
            return "form";
        }
        billService.save(billDTO);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công!");
        return "redirect:/";
    }

    @PostMapping("edit")
    public String editEntity(@Valid @ModelAttribute("bill") BillDTO billDTO,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        new BillDTO().validate(billDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("action", "edit");
            return "form";
        }
        if(CustomValid.validMonth(billService, billDTO.getId(),billDTO.getNumberMonth())){
            model.addAttribute("action", "edit");
            model.addAttribute("message", "Số tháng thay đổi không hợp lệ.");
                return "form";
        }
        billService.save(billDTO);
        redirectAttributes.addFlashAttribute("message","Cập nhật thành công!");
        return "redirect:/";
    }
}
