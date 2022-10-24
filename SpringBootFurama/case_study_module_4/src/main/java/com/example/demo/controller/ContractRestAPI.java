package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.contract.AttachService;
import com.example.demo.models.contract.ContractDetails;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.employee.roles.EmployeeAccount;
import com.example.demo.models.main_service.MainService;
import com.example.demo.service.interface_business.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/contractRest")
@CrossOrigin("*")
//@SessionAttributes("account")
public class ContractRestAPI {
    @Autowired
    IServiceAttachService attachService;

    @Autowired
    IContractDetailsService contractDetailsService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IContractService contractService;

    @Autowired
    IMainService mainService;

    @Autowired
    IEmployeeAccountService accountService;

    @GetMapping("/findAttachByID/{id}")
    public ResponseEntity<AttachService> findAttachServiceById(@PathVariable Integer id) {
        Optional<AttachService> optional = attachService.findById(id);
        return optional.map(x -> new ResponseEntity<>(x, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findService/{id}")
    public ResponseEntity<MainService> findServiceById(@PathVariable Integer id) {
        Optional<MainService> optional = mainService.findById(id);
        return optional.map(x -> new ResponseEntity<>(x, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ContractDetails> saveContractDetails(@RequestBody ContractDetails contractDetails) {
        contractService.updateMoneyById(contractDetails.getContract().getId());
        return new ResponseEntity<>(contractDetailsService.save(contractDetails), HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity<Iterable<ContractDetails>> getList() {
        return new ResponseEntity<>(contractDetailsService.findAll(), HttpStatus.OK);
    }
//
//    @SneakyThrows
//    @PostMapping("/login")
//    public ResponseEntity<EmployeeDTO> loginEmployee(@CookieValue @RequestBody EmployeeAccount account, HttpServletResponse response) {
//        Optional<Employee> employee = employeeService.findAllByUsername(account.getUsername());
//        Cookie username = new Cookie("username", employee.get().getEmployeeAccount().getUsername());
//        Cookie roles = new Cookie("roles", employee.get().getPosition().getName());
//        username.setMaxAge(24 * 60 * 60);
//        roles.setMaxAge(24 * 60 * 60);
//        response.addCookie(username);
//        response.addCookie(roles);
//        return new ResponseEntity<>(new EmployeeDTO(employee.get()), HttpStatus.OK);
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(HttpServletResponse response, HttpServletRequest request) {
//        Stream.of(Optional.ofNullable(request.getCookies()).orElse(new Cookie[0])).forEach(x -> {
//            x.setMaxAge(0);
//            response.addCookie(x);
//        });
//        return new ResponseEntity<>("Success",HttpStatus.OK);
//    }
}
