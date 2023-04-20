package com.java.service.impl;

import com.java.model.Details;
import com.java.repos.IDetailsRepos;
import com.java.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsService implements ITypeService<Details> {

    @Autowired
    IDetailsRepos iDetailsRepos;

    @Override
    public List<Details> findAll(String status) {
        return iDetailsRepos.findAll();
    }

    @Override
    public Details save(Details details) {
        return iDetailsRepos.save(details);
    }

    @Override
    public Details findById(String id) {
        return iDetailsRepos.findById(id).orElse(null);
    }
}
