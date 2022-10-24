package com.example.demo.repos.employee;

import com.example.demo.models.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<EducationDegree,Integer> {
}
