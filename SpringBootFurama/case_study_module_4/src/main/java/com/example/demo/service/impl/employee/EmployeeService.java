package com.example.demo.service.impl.employee;

import com.example.demo.models.employee.Employee;
import com.example.demo.repos.employee.IEmployeeRepository;
import com.example.demo.service.interface_business.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository repository;

    @Override
    public Page<Employee> findAllByName(String keyword, Pageable pageable) {
        return repository.findAllByName(keyword, pageable);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void updateById(Integer id_delete) {
        repository.updateById(id_delete);
    }

    @Override
    public void updateMoneyById(Integer id) {
    }

    @Override
    public Optional<Employee> findAllByUsername(String username) {
        return repository.findAllByUsername(username);
    }
}
