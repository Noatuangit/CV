package service.impl;

import models.professional_furama.Contract;
import utils.Query;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractService {
    public void insertDTO(Timestamp start_day, Timestamp end_day, double deposit, String employee_id, String customer_id, String service_id) {
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.insert_contract)) {
            statement.setTimestamp(1, start_day);
            statement.setTimestamp(2, end_day);
            statement.setDouble(3, deposit);
            statement.setInt(4, Integer.parseInt(service_id));
            statement.setInt(5, Integer.parseInt(employee_id));
            statement.setInt(6, Integer.parseInt(customer_id));
            statement.setInt(7, Integer.parseInt(service_id));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDTO(int id, Timestamp start_day, Timestamp end_day, double deposit, String employee_id, String customer_id, String service_id){
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.update_contract)) {
            statement.setTimestamp(1, start_day);
            statement.setTimestamp(2, end_day);
            statement.setDouble(3, deposit);
            statement.setInt(4, Integer.parseInt(service_id));
            statement.setInt(5, Integer.parseInt(employee_id));
            statement.setInt(6, Integer.parseInt(customer_id));
            statement.setInt(7, Integer.parseInt(service_id));
            statement.setInt(8, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteDTO(int id) {
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.delete_contract)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Contract searchDTO(int id_search) {
        Contract contract= new Contract();
        try(Connection connection = Utils.getConnect();PreparedStatement statement = connection.prepareStatement(Query.search_contract)) {
            statement.setInt(1,id_search);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                contract = Utils.createContract(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }
    public Contract searchDTO(int id_search,String query) {
        Contract contract= new Contract();
        try(Connection connection = Utils.getConnect();PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,id_search);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                contract = Utils.createContractName(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }

    public List<Contract> getList(String query) {
        List<Contract> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = (resultSet.getInt("id"));
                Timestamp start_day = resultSet.getTimestamp("start_date");
                Timestamp end_day = resultSet.getTimestamp("end_date");
                double deposit = resultSet.getDouble("deposit");
                String employee_id = resultSet.getString("en");
                String customer_id = resultSet.getString("cn");
                String service_id = resultSet.getString("sn");
                double total_money = resultSet.getDouble("total_money");
                list.add(new Contract(id, start_day, end_day, deposit, employee_id, customer_id, service_id, total_money));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return list;
    }
}
