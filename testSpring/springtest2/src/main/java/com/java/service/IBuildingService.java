package com.java.service;

import com.java.model.Building;

import java.util.List;
import java.util.Optional;

public interface IBuildingService {
    List<Building> findAll();
    Optional<Building> findById(String id);
}
