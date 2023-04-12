package com.tuanln6.rest;

import com.tuanln6.dto.details.ComputerDetailsDTO;
import com.tuanln6.dto.view.ComputerViewDetailsDTO;
import com.tuanln6.model.ComputerDetails;
import com.tuanln6.model.id.ComputerDetailsID;
import com.tuanln6.service.IComputerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comDetails")
@CrossOrigin("http://localhost:3000")
public class ComputerDetailsRest {
   private final int MAXPAGE = 4;
    @Autowired
    IComputerDetailsService computerDetailsService;

    @GetMapping("")
    public ResponseEntity<Page<ComputerViewDetailsDTO>> findAll(
            @RequestParam(value = "p", defaultValue = "0") Integer page,
            @RequestParam(value = "c", defaultValue = "") String condition) {
        return ResponseEntity.status(HttpStatus.OK).body(computerDetailsService.findAll(condition,PageRequest.of(page, MAXPAGE)));
    }

    @PostMapping("")
    public ResponseEntity<ComputerDetails> saveComputer(@Valid @RequestBody ComputerDetailsDTO computerDetailsDTO){
        return ResponseEntity.status(HttpStatus.OK).body(computerDetailsService.save(new ComputerDetails(computerDetailsDTO)));
    }

    @PutMapping("delete")
    public ResponseEntity<String> deleteById(@RequestBody ComputerViewDetailsDTO computerViewDetailsDTO ){
        computerDetailsService.removeById(new ComputerDetailsID(computerViewDetailsDTO));
        return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
    }

    @PutMapping("")
    public ResponseEntity<String> updateTimeUse(@RequestBody ComputerViewDetailsDTO computerViewDetailsDTO ){
        computerDetailsService.save(new ComputerDetails(computerViewDetailsDTO));
        return ResponseEntity.status(HttpStatus.OK).body("Update success!");
    }

}
