package com.example.demo.repos.main_service;

import com.example.demo.models.main_service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeServiceRepository extends JpaRepository<ServiceType, Integer> {
}
