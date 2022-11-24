package com.example.demo.controller;

import com.example.demo.dto.ContractDTO;
import com.example.demo.models.contract.Contract;
import com.example.demo.service.interface_business.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    final int MAX_DISPLAY = 4;
    @Autowired
    IContractService contractService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IMainService mainService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IServiceAttachService serviceAttachService;

    @GetMapping("")
    public String goHome(Model model, @RequestParam(defaultValue = "0") String name_search,
                         @PageableDefault(size = MAX_DISPLAY)
                                 Pageable pageable) {
        transferDataAddOnContract(model);
        Page<Contract> contracts = contractService.findAllByName(name_search, pageable);
        model.addAttribute("list", converterDataToDTO(contracts));
        model.addAttribute("page_max", contracts.getTotalPages());
        return "contract/index";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model) {
        model.addAttribute("contract", new ContractDTO());
        transferDataAddOnContract(model);
        return "contract/form";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("contract") ContractDTO contract, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            transferDataAddOnContract(model);
                return "contract/form";
        }
        contractService.save(new Contract(contract));
        attributes.addFlashAttribute("message", "Create Success!!!");
        return "redirect:/contract";
    }

    @GetMapping("/edit/{id}")
    public String editContract(Model model, @PathVariable Integer id) {
        assert contractService.findById(id).isPresent();
        model.addAttribute("contract", (contractService.findById(id).get()));
        transferDataAddOnContract(model);
        return "contract/form";
    }

    private List<ContractDTO> converterDataToDTO(Page<Contract> list) {
        List<ContractDTO> result = new ArrayList<>();
        for (Contract contract : list) {
            result.add(new ContractDTO(contract));
        }
        return result;
    }

    @GetMapping("/delete")
    public String deleteContract(@RequestParam("id") Integer id, RedirectAttributes attributes) {
        contractService.updateById(id);
        attributes.addFlashAttribute("message", "Delete Success !!!");
        return "redirect:/contract";
    }


    private void transferDataAddOnContract(Model model) {
        model.addAttribute("customerList", customerService.findAllByName("", Pageable.unpaged()));
        model.addAttribute("employeeList", employeeService.findAllByName("", Pageable.unpaged()));
        model.addAttribute("serviceList", mainService.findAllByName("", Pageable.unpaged()));
        model.addAttribute("attachList", serviceAttachService.findAll());
    }
}
