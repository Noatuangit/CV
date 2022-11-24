package com.example.demo.controller;

import com.example.demo.DAO.PersonDAO;
import com.example.demo.error.handleException.NotFoundEntityById;
import com.example.demo.models.Person;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/peoples")
public class PeopleController {
    @Autowired
    IPersonService service;

    @PostMapping("")
    public ResponseEntity<Person> savePerson(@Valid @RequestBody PersonDAO personDAO) {
        return new ResponseEntity<>(service.save(new Person(personDAO)), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/houseHolds/{idHouseHold}")
    public ResponseEntity<Person> savePeopleInHouseHold(@PathVariable Long id, @PathVariable String idHouseHold) throws NotFoundEntityById {
        service.savePersonInHouseHold(id, idHouseHold);
        return new ResponseEntity<>(service.findById(id), HttpStatus.CREATED);
    }
}
