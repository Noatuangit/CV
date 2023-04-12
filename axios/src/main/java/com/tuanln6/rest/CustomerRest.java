package com.tuanln6.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuanln6.dto.customer.CustomerDTO;
import com.tuanln6.dto.customer.CustomerEditDTO;
import com.tuanln6.model.Customer;
import com.tuanln6.service.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerRest {
    final int MAXDISPLAY = 4;
    @Autowired
    ICustomerService customerService;


    @GetMapping("")
    public ResponseEntity<Page<Customer>> findAllByCondition(@RequestParam(value = "c", defaultValue = "") String condition,
                                                             @RequestParam(name = "p", defaultValue = "0") Integer page) {
        return new ResponseEntity<>(customerService.findAllByConditionAndStatusOn(condition, PageRequest.of(page, MAXDISPLAY)), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Integer> updateStatusById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateStatusById(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customerDTO));
    }


    @PutMapping("")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody CustomerEditDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(dto));
    }
}
