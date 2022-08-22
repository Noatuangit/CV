package service.impl;

import models.professional_furama.Service;
import service.DTOService;
import utils.Query;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceControl implements DTOService<Service> {

    @Override
    public void insertDTO(Service service) throws SQLException {
        try (Connection connection = Utils.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(Query.insert_service)) {
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMax_people());
            preparedStatement.setString(6, service.getStandard_room());
            preparedStatement.setString(7, service.getDescription_other_convenience());
            preparedStatement.setDouble(8, service.getPool_area());
            preparedStatement.setInt(9, service.getNumber_of_floors());
            preparedStatement.setString(10, service.getFacility_text());
            preparedStatement.setInt(11, Integer.parseInt(service.getRent_type()));
            preparedStatement.setInt(12, Integer.parseInt(service.getService_type()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateDTO(Service service) throws SQLException {
        try (Connection connection = Utils.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(Query.update_service)) {
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMax_people());
            preparedStatement.setString(6, service.getStandard_room());
            preparedStatement.setString(7, service.getDescription_other_convenience());
            preparedStatement.setDouble(8, service.getPool_area());
            preparedStatement.setInt(9, service.getNumber_of_floors());
            preparedStatement.setString(10, service.getFacility_text());
            preparedStatement.setInt(11, Integer.parseInt(service.getRent_type()));
            preparedStatement.setInt(12, Integer.parseInt(service.getService_type()));
            preparedStatement.setInt(13, service.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteDTO(int id) {
        try (Connection connection = Utils.getConnect();
             PreparedStatement statement = connection.prepareStatement(Query.delete_service)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Service> searchDTOByName(String name_search) {
        List<Service> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statements = connection.prepareStatement(Query.search_name_service)) {
            statements.setString(1, name_search);
            ResultSet resultSet = statements.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.searchService(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Service searchDTO(int id_Search) {
        Service service = null;
        try (Connection connection = Utils.getConnect();
             PreparedStatement statement = connection.prepareStatement(Query.search_service)) {
            statement.setInt(1, id_Search);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                service = Utils.searchService(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return service;
    }

    @Override
    public List<Service> getList(String query, int page) {
        return null;
    }

    public List<Service> getList(String query) {
        List<Service> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("sn");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("service_cost");
                int max_people = resultSet.getInt("max_people");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                String facility_text = resultSet.getString("facility_text");
                String rent_type = resultSet.getString("rtn");
                String service_type = resultSet.getString("stn");
                list.add(new Service(id, name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_text, rent_type, service_type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Service> getList() {
        List<Service> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.list_service_to_Contract)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.searchService(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
