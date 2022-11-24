package com.example.demo.service.impl;

import com.example.demo.error.handleException.NotFoundEntityById;
import com.example.demo.models.Person;
import com.example.demo.repos.IPersonRepos;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {
    @Autowired
    IPersonRepos repos;

    @Override
    public List<Person> findAll() {
        return repos.findAll();
    }

    @Override
    public Person save(Person person) {
        return repos.save(person);
    }

    @Override
    public void savePersonInHouseHold(Long id, String idHouseHold) {
        repos.savePersonInHouseHold(id, idHouseHold);
    }

    @Override
    public Person findById(Long id) throws NotFoundEntityById {
        Optional<Person> optionalPerson = repos.findById(id);
        if (optionalPerson.isPresent()) return optionalPerson.get();
        throw new NotFoundEntityById("Not found any Person with id " + id);
    }
}
