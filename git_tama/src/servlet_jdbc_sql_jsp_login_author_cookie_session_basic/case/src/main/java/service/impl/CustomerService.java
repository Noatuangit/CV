package service.impl;

import controller.MainServlet;
import models.person.Customer;
import utils.Query;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public void insertDTO(Customer customer) throws SQLException {
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.insert_customer)) {
            statement.setInt(1, customer.getId());
            statement.setInt(2, Integer.parseInt(customer.getCustomer_type()));
            statement.setString(3, customer.getName());
            statement.setDate(4, customer.getBirthday());
            statement.setString(5, customer.getId_card());
            statement.setByte(6, Byte.parseByte(customer.getGender()));
            statement.setString(7, customer.getPhone());
            statement.setString(8, customer.getEmail());
            statement.setString(9, customer.getAddress());
            statement.executeUpdate();
        }
    }

    public void updateDTO(Customer customer) throws SQLException {
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.update_customer)) {
            statement.setInt(1, customer.getId());
            statement.setInt(2, Integer.parseInt(customer.getCustomer_type()));
            statement.setString(3, customer.getName());
            statement.setDate(4, customer.getBirthday());
            statement.setString(5, customer.getId_card());
            statement.setByte(6, Byte.parseByte(customer.getGender()));
            statement.setString(7, customer.getPhone());
            statement.setString(8, customer.getEmail());
            statement.setString(9, customer.getAddress());
            statement.setInt(10, customer.getId());
            statement.executeUpdate();
        }
    }

    public void deleteDTO(int id) {
        try (Connection connection = Utils.getConnect(); CallableStatement statement = connection.prepareCall(Query.delete_customer)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> searchDTOByName(String name) {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect();
             PreparedStatement statement = connection.prepareStatement(Query.search_name_customer)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.createCustomer(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Customer searchDTO(int id_search) {
        Customer customer = null;
        try (Connection connection = Utils.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.search_customer.concat(String.valueOf(id_search)))) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = Utils.createCustomer(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }


    public List<Customer> getList(String query,int limit, int offset) {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, limit);
            statement.setInt(2, offset * MainServlet.MAX_LIMIT_DISPLAY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type_customer = resultSet.getString("tcn");
                String name_customer = resultSet.getString("cn");
                Date birthday = (resultSet.getDate("birthday"));
                String id_card = resultSet.getString("id_card");
                String gender = Utils.getGender(resultSet.getInt("gender"));
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                list.add(new Customer(id, type_customer, name_customer, birthday, gender, id_card, phone, email, address));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Customer> getList() {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.list_customer_to_Contract)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.createCustomer(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int get_all_customer(String query) {
        int amount = 0;
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                amount = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amount;
    }
}

