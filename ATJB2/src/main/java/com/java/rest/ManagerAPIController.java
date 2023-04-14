package com.java.rest;

import com.java.dto.ComDetailsDTO;
import com.java.model.AddService;
import com.java.model.Computer;
import com.java.model.ComputerDetails;
import com.java.model.Customer;
import com.java.service.IComputerDetailService;
import com.java.service.IComputerService;
import com.java.service.ICustomerService;
import com.java.service.IServiceService;
import com.java.service.impl.ComputerDetailServiceImpl;
import com.java.service.impl.ComputerServiceImpl;
import com.java.service.impl.CustomerServiceImpl;
import com.java.service.impl.ServiceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin("/*")
public class ManagerAPIController {
	IComputerDetailService computerDetailService;
	ICustomerService customerService;
	IComputerService computerService;
	IServiceService serviceService;

	public ManagerAPIController(ComputerDetailServiceImpl service, CustomerServiceImpl customerService,
			ServiceServiceImpl serviceService, ComputerServiceImpl computerService) {
		this.computerDetailService = service;
		this.customerService = customerService;
		this.computerService = computerService;
		this.serviceService = serviceService;
	}

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/service")
	public ResponseEntity<List<AddService>> getAllService() {
		return new ResponseEntity<>(serviceService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/computer")
	public ResponseEntity<List<Computer>> getAllComputer() {
		return new ResponseEntity<>(computerService.findAllByStatusNotWaiting(), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<ComputerDetails> saveComputerDetails(@Valid @RequestBody ComDetailsDTO comDetailsDTO) {
		computerService.updateStatusById("waiting", comDetailsDTO.getComputer_id());
		return new ResponseEntity<>(computerDetailService.saveEntity(comDetailsDTO), HttpStatus.OK);
	}
}
