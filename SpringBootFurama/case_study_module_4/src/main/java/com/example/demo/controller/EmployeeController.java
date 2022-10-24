package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.error.exception.NotPermission;
import com.example.demo.models.employee.Division;
import com.example.demo.models.employee.EducationDegree;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.employee.Position;
import com.example.demo.service.ITypeService;
import com.example.demo.service.interface_business.IEmployeeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    final int MAX_DISPLAY = 4;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ITypeService<EducationDegree> educationService;

    @Autowired
    ITypeService<Division> divisionService;

    @Autowired
    ITypeService<Position> positionService;
    List<String> list = new ArrayList<>(Arrays.asList("President", "Manager"));
    @RequestMapping("")
    public String goHomePage(Model model, @RequestParam(defaultValue = "") String name_search,
                             @PageableDefault(size = MAX_DISPLAY, sort = "name", direction = Sort.Direction.ASC)
                                     Pageable pageable) {
        model.addAttribute("list", employeeService.findAllByName(name_search, pageable));
        model.addAttribute("name_search", name_search);
        return "employee/index";
    }


    @SneakyThrows
    @RequestMapping("/create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        transferDataAddOnEmployee(model);
        return "employee/form";
    }

    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", new EmployeeDTO(employee.get()));
            transferDataAddOnEmployee(model);
            return "employee/form";
        }
        return "redirect:/";
    }

    @PostMapping("/update")
    public String createTargetEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            transferDataAddOnEmployee(model);
            return "employee/form";
        }
        Employee employee = new Employee(employeeDTO);
        if (employeeDTO.getId() == null) {
            employeeService.save(employee);
            attributes.addFlashAttribute("message", "Create Success !!!");
        } else {
            employee.setId(employeeDTO.getId());
            employeeService.save(employee);
            attributes.addFlashAttribute("message", "Edit Success !!!");
        }
        return "redirect:/employee";
    }


    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") Integer id,RedirectAttributes attributes) {
        employeeService.updateById(id);
        attributes.addFlashAttribute("message", "Delete Success !!!");
        return "redirect:/employee";
    }

    private void transferDataAddOnEmployee(Model model) {
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("eduList", educationService.findAll());
        model.addAttribute("divList", divisionService.findAll());
    }
}
