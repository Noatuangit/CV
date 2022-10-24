package com.example.demo.service.impl.main_service;

import com.example.demo.models.main_service.RentType;
import com.example.demo.repos.main_service.IRentRepository;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRentService implements ITypeService<RentType> {
    @Autowired
    IRentRepository rentRepository;

    @Override
    public List<RentType> findAll() {
        return rentRepository.findAll();
    }
}
