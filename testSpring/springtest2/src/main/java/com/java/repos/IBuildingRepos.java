package com.java.repos;

import com.java.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBuildingRepos extends JpaRepository<Building,String> {
}
