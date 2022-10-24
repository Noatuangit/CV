package com.example.demo.repos.employee.roles;

import com.example.demo.models.employee.roles.EmployeeRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRolesRepository extends JpaRepository<EmployeeRoles, Integer> {
}
