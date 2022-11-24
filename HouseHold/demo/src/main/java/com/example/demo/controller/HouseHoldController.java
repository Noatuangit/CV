package com.example.demo.controller;

import com.example.demo.DAO.HouseHoldDAO;
import com.example.demo.error.handleException.EmptyListPeople;
import com.example.demo.error.handleException.NotFoundEntityById;
import com.example.demo.models.HouseHold;
import com.example.demo.models.Person;
import com.example.demo.service.IHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin("/*")
@RequestMapping("/api")
public class HouseHoldController {
    final int MAX_DISPLAY = 5;

    @Autowired
    IHouseHoldService iHouseHoldService;

    @GetMapping("")
    public ResponseEntity<Page<HouseHold>> findAll(@RequestParam(defaultValue = "") String name_search,
                                                   @RequestParam(defaultValue = "") String address_search,
                                                   @RequestParam(defaultValue = "") String date_search,
                                                   @PageableDefault(size = MAX_DISPLAY, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(iHouseHoldService.findAll(name_search, address_search, date_search, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Set<Person>> findListPeopleInId(@PathVariable String id) throws NotFoundEntityById, EmptyListPeople {
        HouseHold houseHold = iHouseHoldService.findById(id);
        if (houseHold.getPersonSet().isEmpty()) throw new EmptyListPeople("No people live in " + id);
        return new ResponseEntity<>(houseHold.getPersonSet(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<HouseHold> saveHouseHold(@Valid @RequestBody HouseHoldDAO dao) {
        return new ResponseEntity<>(iHouseHoldService.save(new HouseHold(dao)), HttpStatus.CREATED);
    }

    @PatchMapping("")
    public ResponseEntity<HouseHold> editHouseHold(@Valid @RequestBody HouseHoldDAO dao) throws NotFoundEntityById {
        HouseHold houseHoldTemp = iHouseHoldService.findById(dao.getId());
        HouseHold houseHold = HouseHold.builder().id(dao.getId()).name(dao.getName()).address(dao.getAddress()).dateCreate(dao.getDateCreate()).personSet(houseHoldTemp.getPersonSet()).build();
        return new ResponseEntity<>(iHouseHoldService.save(houseHold), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HouseHold> deleteByID(@PathVariable String id) {
        iHouseHoldService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteAll")
    public ResponseEntity<Page<HouseHold>> deleteAllById(@RequestParam(value = "listId", defaultValue = "") List<String> list) {
        iHouseHoldService.removeAllById(list);
        return new ResponseEntity<>(iHouseHoldService.findAll("", "", "", Pageable.unpaged()), HttpStatus.OK);
    }
}