package com.example.demo.service.interface_business;

import com.example.demo.models.contract.AttachService;

import java.util.List;
import java.util.Optional;

public interface IServiceAttachService {
    Optional<AttachService> findById(Integer id);

    List<AttachService> findAll();

}
