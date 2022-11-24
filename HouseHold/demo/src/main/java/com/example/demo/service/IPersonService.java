package com.example.demo.service;

import com.example.demo.error.handleException.NotFoundEntityById;
import com.example.demo.models.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();

    Person save(Person person);

    void savePersonInHouseHold(Long id, String idHouseHold);

    Person findById(Long id) throws NotFoundEntityById;
}
