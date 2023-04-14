package com.java.service;

import com.java.model.AddService;

import java.util.List;

public interface IServiceService {
    List<AddService> findAllByName(String name, Integer page);
    AddService findById(String id);
    void save (AddService addService);
    void updateById(String id);
    Integer countFindAllByName(String name);
    List<AddService> findAll();
}
