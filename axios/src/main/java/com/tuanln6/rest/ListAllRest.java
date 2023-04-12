package com.tuanln6.rest;

import com.tuanln6.model.AddOnService;
import com.tuanln6.model.Computer;
import com.tuanln6.model.Customer;
import com.tuanln6.service.IComputerService;
import com.tuanln6.service.ICustomerService;
import com.tuanln6.service.IServiceDetailsService;
import com.tuanln6.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/list")
public class ListAllRest {
    @Autowired
    ICustomerService customerService;
    @Autowired
    IComputerService computerService;
    @Autowired
    IServiceService serviceService;

    @Autowired
    IServiceDetailsService serviceDetailsService;

    @GetMapping("listCus")
    public ResponseEntity<List<Customer>> findAllCustomer() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }

    @GetMapping("listSer")
    public ResponseEntity<List<AddOnService>> findAllService() {
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.findAll());
    }

    @GetMapping("listCom")
    public ResponseEntity<List<Computer>> findAllComputerNotStatusOffOrWaiting() {
        return ResponseEntity.status(HttpStatus.OK).body(computerService.findAllNotStatusOffOrWaiting());
    }

    @GetMapping("listComEdit")
    public ResponseEntity<List<Computer>> findAllComputer(@RequestParam String computerId) {
        return ResponseEntity.status(HttpStatus.OK).body(computerService.findAll(computerId));
    }

    @GetMapping("total")
    public ResponseEntity<Page<String[]>> findTotal(@RequestParam(name = "p", defaultValue = "0") Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceDetailsService.findAllTotal(PageRequest.of(page, 4)));
    }

}
