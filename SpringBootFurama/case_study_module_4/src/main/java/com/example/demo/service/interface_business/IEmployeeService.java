package com.example.demo.service.interface_business;

import com.example.demo.models.employee.Employee;
import com.example.demo.service.IBaseService;
import com.example.demo.service.ITypeService;

import java.util.Optional;

public interface IEmployeeService extends IBaseService<Employee> {
    Optional<Employee> findAllByUsername(String username);

}
