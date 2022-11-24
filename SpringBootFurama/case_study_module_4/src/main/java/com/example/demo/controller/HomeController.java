package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.employee.roles.EmployeeAccount;
import com.example.demo.service.interface_business.IEmployeeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
public class HomeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("")
    public String goHome(Model model, @CookieValue(name = "username", defaultValue = "") String username, @CookieValue(name = "roles", defaultValue = "") String roles) {
        if (!(username.isEmpty())) {
            model.addAttribute("username", username);
        }
        return "home";
    }


    @SneakyThrows
    @PostMapping("/login")
    public String loginEmployee(@CookieValue @RequestBody EmployeeAccount account, HttpServletResponse response, Model model) {
        Optional<Employee> employee = employeeService.findAllByUsername(account.getUsername());
        Cookie username = new Cookie("username", employee.get().getEmployeeAccount().getUsername());
        Cookie roles = new Cookie("roles", employee.get().getPosition().getName());
        username.setMaxAge(24 * 60 * 60);
        roles.setMaxAge(24 * 60 * 60);
        response.addCookie(username);
        response.addCookie(roles);
        model.addAttribute("username", employee.get().getName());
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        Stream.of(Optional.ofNullable(request.getCookies()).orElse(new Cookie[0])).forEach(x -> {
            x.setMaxAge(0);
            response.addCookie(x);
        });
        return "redirect:/";
    }
}
