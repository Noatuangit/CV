package com.example.demo.service.impl.main_service;

import com.example.demo.models.main_service.ServiceType;
import com.example.demo.repos.main_service.ITypeServiceRepository;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements ITypeService<ServiceType> {
    @Autowired
    ITypeServiceRepository repository;

    @Override
    public List<ServiceType> findAll() {
        return repository.findAll();
    }
}
