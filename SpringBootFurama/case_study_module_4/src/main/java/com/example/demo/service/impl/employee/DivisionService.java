package com.example.demo.service.impl.employee;

import com.example.demo.models.employee.Division;
import com.example.demo.repos.employee.IDivisionRepository;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements ITypeService<Division> {
    @Autowired
    IDivisionRepository repository;

    @Override
    public List<Division> findAll() {
        return repository.findAll();
    }
}
