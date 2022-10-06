package service.impl.employee;

import models.person.Employee;
import reposition.IBaseRepository;
import reposition.impl.employee.EmployeeRepository;
import service.IBaseService;
import utils.ValidData;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IBaseService<Employee> {
    private final IBaseRepository<Employee> repository = new EmployeeRepository();


    @Override
    public Map<String, String> save(Employee employee) throws SQLException {
        Map<String, String> mapError = ValidData.validData(employee);
        if (mapError.isEmpty()) {
            repository.save(employee);
        }
        return mapError;
    }

    @Override
    public Map<String, String> update(Employee employee, int id) throws SQLException {
        Map<String, String> mapError = ValidData.validData(employee);
        if (mapError.isEmpty()) {
            repository.update(employee, id);
        }
        return mapError;
    }

    @Override
    public void removeById(int id) {
        repository.removeById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id);
    }

    @Override
    public int countAmountFindAll() {
        return repository.countAmountFindAll();
    }

    @Override
    public List<Employee> getList(int offset) {
        return repository.getList(offset,"");
    }

    @Override
    public List<Employee> getList() {
        return repository.getList();
    }

    @Override
    public List<Employee> getListHaveContract(int offset) {
        return null;
    }
}
