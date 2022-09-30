package com.example.demo.controller;

import com.example.demo.dto.MainServiceDTO;
import com.example.demo.models.main_service.MainService;
import com.example.demo.models.main_service.RentType;
import com.example.demo.models.main_service.ServiceType;
import com.example.demo.service.ITypeService;
import com.example.demo.service.interface_business.IMainService;
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
@RequestMapping("/service")
public class MainServiceController {
    final int MAX_DISPLAY = 4;

    @Autowired
    IMainService mainService;

    @Autowired
    ITypeService<RentType> iRentService;

    @Autowired
    ITypeService<ServiceType> serviceType;

    @GetMapping("")
    public String goHome(Model model, @RequestParam(defaultValue = "") String name_search,
                         @PageableDefault(size = MAX_DISPLAY, sort = "name", direction = Sort.Direction.ASC)
                                 Pageable pageable) {
        model.addAttribute("list", mainService.findAllByName(name_search, pageable));
        return "service/index";
    }

    @GetMapping("/create")
    public String createService(Model model) {
        model.addAttribute("service", new MainServiceDTO());
        transferDataAddOnService(model);
        return "service/form";
    }

    @GetMapping("/edit/{id}")
    public String editService(@PathVariable Integer id, Model model) {
        Optional<MainService> service = mainService.findById(id);
        assert service.isPresent();
        model.addAttribute("service", new MainServiceDTO(service.get()));
        transferDataAddOnService(model);
        return "service/form";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("service") MainServiceDTO service, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            transferDataAddOnService(model);
            return "service/form";
        }

        if (service.getId() == null) {
            mainService.save(new MainService(service));
            attributes.addFlashAttribute("message", "Create Success !!!");
        } else {
            MainService serviceEdit = new MainService(service);
            serviceEdit.setId(service.getId());
            mainService.save(serviceEdit);
            attributes.addFlashAttribute("message", "Edit Success !!!");
        }
        return "redirect:/service";
    }

    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") Integer id, RedirectAttributes attributes) {
        mainService.updateById(id);
        attributes.addFlashAttribute("message", "Delete Success !!!");
        return "redirect:/service";
    }

    private void transferDataAddOnService(Model model) {
        model.addAttribute("rentList", iRentService.findAll());
        model.addAttribute("typeList", serviceType.findAll());
    }
}
