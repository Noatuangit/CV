package com.java.repos;

import com.java.model.AddService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServiceRepos {
     List<AddService> findAllByName( String name, Integer page);

    AddService findById(String id);

    void save(AddService addService);

    int countFindAllByName(String name);
    void removeById(String id);
    List<AddService> findAll();

     void updateById( String id);
}
