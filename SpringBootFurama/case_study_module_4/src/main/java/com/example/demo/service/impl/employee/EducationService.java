package com.example.demo.service.impl.employee;

import com.example.demo.models.employee.EducationDegree;
import com.example.demo.repos.employee.IEducationRepository;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements ITypeService<EducationDegree> {
    @Autowired
    IEducationRepository repository;

    @Override
    public List<EducationDegree> findAll() {
        return repository.findAll();
    }
}
