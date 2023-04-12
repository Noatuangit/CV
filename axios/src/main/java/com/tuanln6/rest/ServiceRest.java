package com.tuanln6.rest;

import com.tuanln6.dto.service.ServiceDTO;
import com.tuanln6.model.AddOnService;

import com.tuanln6.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin("http://localhost:3000")
public class ServiceRest {
    final int MAXPAGE = 4;
    @Autowired
    IServiceService serviceService;

    @GetMapping("")
    public ResponseEntity<Page<AddOnService>> getListWithCondition(
            @RequestParam(value = "c", defaultValue = "") String condition,
            @RequestParam(name = "p", defaultValue = "0") Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.findAllByCondition(condition, PageRequest.of(page, MAXPAGE)));
    }

    @GetMapping("{id}")
    public ResponseEntity<AddOnService> findById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<AddOnService> saveCustomer(@Valid @RequestBody ServiceDTO serviceDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.save(serviceDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<Integer> updateStatusById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.updateStatusById(id));
    }
}
