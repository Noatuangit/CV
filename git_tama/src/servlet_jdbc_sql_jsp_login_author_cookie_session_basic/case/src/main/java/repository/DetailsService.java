package repository;

import models.professional_furama.ContractDetail;
import utils.Query;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DetailsService {

    public void insertDTO(ContractDetail contractDetail) throws SQLException {
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.insert_contract_details)) {
            statement.setInt(1, contractDetail.getId_details());
            statement.setInt(2, contractDetail.getId_contract());
            statement.setInt(3, contractDetail.getId_attach_service());
            statement.setInt(4, contractDetail.getQuantity());
            statement.executeUpdate();
        }
    }

    public List<ContractDetail> searchContractDetail(int id) {
        List<ContractDetail> contractDetail = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.search_contract_details)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contractDetail.add(Utils.createContractDetails(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contractDetail;
    }

    public List<ContractDetail> getList(String table) {
        List<ContractDetail> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.list_type.concat(table))) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.createContractDetails(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
