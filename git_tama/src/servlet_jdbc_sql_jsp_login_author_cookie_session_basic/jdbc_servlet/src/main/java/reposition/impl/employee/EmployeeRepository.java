package reposition.impl.employee;

import models.person.Customer;
import models.person.Employee;
import reposition.IBaseRepository;
import utils.ConnectData;
import utils.CreateCustomer;
import utils.CreateEmployee;
import utils.FindAmountPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IBaseRepository<Employee> {
    public final int MAX_LIMIT_DISPLAY = 5;

    public final String insert_employee = "INSERT INTO employee (`name`, `birthday`, `id_card`, `salary`, `phone`, `email`, `address`, `position_id`,`education_degree_id`,`division_id`) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";

    public final String list_employee_offset = "SELECT * FROM employee where `status` = 'on' order by id asc limit ? offset ?";


    public final String list_employee_to_Contract = "select * from employee";

    public final String update_employee = "UPDATE employee SET `name` = ?, `birthday` = ?, `id_card` = ?, `salary` = ?, `phone` = ?, `email` = ?, `address` = ?, `position_id` = ?, `education_degree_id` = ?, `division_id` = ? WHERE id = ?";

    public final String delete_employee = "update employee set `status` = 'off' where id = ?";

    public final String search_name_employee = "select * from employee where name regexp ?";

    public final String count_list = "select count(*) from employee where `status` = 'on'";

    public final String search_employee_by_id = "select * from employee where id = ?";

    @Override
    public void save(Employee employee) throws SQLException {
        try (Connection connect = ConnectData.getConnect(); PreparedStatement statement = connect.prepareStatement(insert_employee)) {
            CreateEmployee.setValueInQuery(statement, employee);
            statement.executeUpdate();

        }
    }

    @Override
    public void update(Employee employee, int id) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(update_employee)) {
            statement.setInt(11, id);
            CreateEmployee.setValueInQuery(statement, employee);
            statement.executeUpdate();
        }
    }

    @Override
    public void removeById(int id) {
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(delete_employee)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(search_name_employee)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateEmployee.createEmployee(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(search_employee_by_id)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = CreateEmployee.createEmployee(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public int countAmountFindAll() {
        return FindAmountPage.findAmountPage(count_list,MAX_LIMIT_DISPLAY);
    }

    @Override
    public List<Employee> getList(int offset, String query) {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(list_employee_offset)) {
            statement.setInt(1, MAX_LIMIT_DISPLAY);
            statement.setInt(2, offset * MAX_LIMIT_DISPLAY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateEmployee.createEmployee(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Employee> getList() {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(list_employee_to_Contract)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateEmployee.createEmployee(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
