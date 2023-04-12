package com.tuanln6.rest;

import com.tuanln6.dto.computer.ComputerDTO;
import com.tuanln6.model.Computer;

import com.tuanln6.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/computer")
@CrossOrigin("http://localhost:3000")
public class ComputerRest {
    final int MAXDISPLAY = 4;
    @Autowired
    IComputerService computerService;

    @GetMapping("")
    public ResponseEntity<Page<Computer>> findAllByCondition(@RequestParam(value = "c", defaultValue = "") String condition,
                                                             @RequestParam(name = "p", defaultValue = "0") Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(computerService.findAllByCondition(condition, PageRequest.of(page, MAXDISPLAY)));
    }


    @GetMapping("{id}")
    public ResponseEntity<Computer> findById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(computerService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Computer> saveDTO(@Valid @RequestBody ComputerDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(computerService.save(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<Integer> updateStatusById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(computerService.updateStatusById("off", id));
    }
}
