package com.example.demo.service.impl.contract;

import com.example.demo.models.contract.AttachService;
import com.example.demo.repos.contract.IAttachServiceRepository;
import com.example.demo.service.interface_business.IServiceAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAttachService implements IServiceAttachService {

    @Autowired
    IAttachServiceRepository repository;

    @Override
    public Optional<AttachService> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<AttachService> findAll() {
        return repository.findAll();
    }
}
