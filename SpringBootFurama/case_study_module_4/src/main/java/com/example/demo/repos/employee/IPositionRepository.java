package com.example.demo.repos.employee;

import com.example.demo.models.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
