package com.example.demo.service.impl.employee;

import com.example.demo.models.employee.Position;
import com.example.demo.repos.employee.IPositionRepository;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements ITypeService<Position> {
    @Autowired
    IPositionRepository repository;

    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }
}
