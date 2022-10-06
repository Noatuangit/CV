package com.example.demo.controller;

import com.example.demo.models.contract.AttachService;
import com.example.demo.models.contract.ContractDetails;
import com.example.demo.models.main_service.MainService;
import com.example.demo.service.interface_business.IContractDetailsService;
import com.example.demo.service.interface_business.IContractService;
import com.example.demo.service.interface_business.IMainService;
import com.example.demo.service.interface_business.IServiceAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contractRest")
@CrossOrigin("*")
public class ContractRestAPI {
    @Autowired
    IServiceAttachService attachService;

    @Autowired
    IContractDetailsService contractDetailsService;

    @Autowired
    IContractService contractService;

    @Autowired
    IMainService mainService;

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

}
