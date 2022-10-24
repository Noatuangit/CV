package com.example.demo.service.impl.main_service;

import com.example.demo.models.main_service.MainService;
import com.example.demo.repos.main_service.IMainServiceRepository;
import com.example.demo.service.interface_business.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceMainService implements IMainService {
    @Autowired
    IMainServiceRepository repository;

    @Override
    public Page<MainService> findAllByName(String keyword, Pageable pageable) {
        return repository.findAllByName(keyword, pageable);
    }

    @Override
    public Optional<MainService> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(MainService mainService) {
        repository.save(mainService);
    }

    @Override
    public void updateById(Integer id_delete) {
        repository.updateById(id_delete);
    }

    @Override
    public void updateMoneyById(Integer id) {

    }
}
