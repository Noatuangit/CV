package service.impl;

import models.person.Employee;
import service.DTOService;
import utils.Query;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements DTOService<Employee> {

    @Override
    public void insertDTO(Employee e) throws SQLException {
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.insert_employee)) {
            statement.setInt(1, e.getId());
            statement.setString(2, e.getName());
            statement.setDate(3, e.getBirthday());
            statement.setString(4, e.getId_card());
            statement.setDouble(5, e.getSalary());
            statement.setString(6, e.getPhone());
            statement.setString(7, e.getEmail());
            statement.setString(8, e.getAddress());
            statement.setString(9, e.getPositions());
            statement.setString(10, e.getEducation_degree());
            statement.setString(11, e.getDivision());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateDTO(Employee e) throws SQLException {
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.update_employee)) {
            statement.setInt(1, e.getId());
            statement.setString(2, e.getName());
            statement.setDate(3, e.getBirthday());
            statement.setString(4, e.getId_card());
            statement.setDouble(5, e.getSalary());
            statement.setString(6, e.getPhone());
            statement.setString(7, e.getEmail());
            statement.setString(8, e.getAddress());
            statement.setString(9, e.getPositions());
            statement.setString(10, e.getEducation_degree());
            statement.setString(11, e.getDivision());
            statement.setInt(12, e.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteDTO(int id) {
        try (Connection connection = Utils.getConnect(); CallableStatement statement = connection.prepareCall(Query.delete_employee)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> searchDTOByName(String name_search) {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.search_name_employee)) {
            statement.setString(1, name_search);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.createEmployee(resultSet));
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Employee searchDTO(int id_search) {
        Employee employee = null;
        try (Connection connection = Utils.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(Query.search_employee.concat(String.valueOf(id_search)))) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = Utils.createEmployee(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> getList(String query, int page) {
        return null;
    }

    public List<Employee> getList(String query) {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate("birthday");
                String id_card = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positions = resultSet.getString("pn");
                String education_degree = resultSet.getString("edn");
                String division = resultSet.getString("dn");
                list.add(new Employee(id, name, birthday, id_card, salary, phone, email, address, positions, education_degree, division));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Employee> getList() {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.list_employee_to_Contract)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.createEmployee(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
