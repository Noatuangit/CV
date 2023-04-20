package com.java.service.impl;

import com.java.model.Building;
import com.java.repos.IBuildingRepos;
import com.java.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements IBuildingService {
    @Autowired
    IBuildingRepos buildingRepos;

    @Override
    public List<Building> findAll() {
        return buildingRepos.findAll();
    }

    @Override
    public Optional<Building> findById(String id) {
        return buildingRepos.findById(id);
    }
}
