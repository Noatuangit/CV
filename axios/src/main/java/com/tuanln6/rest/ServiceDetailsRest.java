package com.tuanln6.rest;

import com.tuanln6.dto.details.ServiceDetailsDTO;
import com.tuanln6.dto.view.ServiceViewDetailsDTO;
import com.tuanln6.model.ServiceDetails;
import com.tuanln6.model.id.ServiceDetailsID;
import com.tuanln6.service.IServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/serDetails")
@CrossOrigin("http://localhost:3000")
public class ServiceDetailsRest {

    private final int MAXPAGE = 4;
    @Autowired
    IServiceDetailsService serviceDetailsService;

    @GetMapping("")
    public ResponseEntity<Page<ServiceViewDetailsDTO>> findAll(@RequestParam(value = "p", defaultValue = "0") Integer page,
                                                               @RequestParam(value = "c", defaultValue = "") String condition) {
        return ResponseEntity.status(HttpStatus.OK).body(serviceDetailsService.findAll(condition, PageRequest.of(page, MAXPAGE)));
    }

    @PutMapping("delete")
    public ResponseEntity<String> removeById(@RequestBody ServiceViewDetailsDTO serviceViewDetailsDTO){
        serviceDetailsService.removeById(new ServiceDetailsID(serviceViewDetailsDTO));
        return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
    }

    @PostMapping("")
    public ResponseEntity<ServiceViewDetailsDTO> save(@Valid @RequestBody ServiceDetailsDTO ServiceDetailsDTO){
        return ResponseEntity.status(HttpStatus.OK).body((serviceDetailsService.save(new ServiceDetails(ServiceDetailsDTO))));
    }

}
