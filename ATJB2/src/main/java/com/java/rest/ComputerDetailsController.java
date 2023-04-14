package com.java.rest;

import com.java.dto.ComDetailsDTO;
import com.java.model.ComputerDetails;
 import com.java.service.IComputerDetailService;
import com.java.service.IComputerService;
import com.java.service.impl.ComputerDetailServiceImpl;
import com.java.service.impl.ComputerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("comDetails")
@CrossOrigin("/*")
public class ComputerDetailsController {
    IComputerDetailService computerDetailService;
    IComputerService computerService;

    public ComputerDetailsController(ComputerDetailServiceImpl computerDetailService,
                                     ComputerServiceImpl computerService) {
        this.computerDetailService = computerDetailService;
        this.computerService = computerService;
    }

    @PostMapping("")
    public ResponseEntity<ComputerDetails> saveComputerDetails(@Valid @RequestBody ComDetailsDTO comDetailsDTO) {
        computerService.updateStatusById("waiting", comDetailsDTO.getComputer_id());
        return new ResponseEntity<>(computerDetailService.saveEntity(comDetailsDTO), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteComputerDetails(@RequestBody ComDetailsDTO comDetailsDTO) {
        computerDetailService.removeEntity(comDetailsDTO);
        computerService.updateStatusById("on", comDetailsDTO.getComputer_id());
        return new ResponseEntity<>("message", HttpStatus.OK);
    }
}
