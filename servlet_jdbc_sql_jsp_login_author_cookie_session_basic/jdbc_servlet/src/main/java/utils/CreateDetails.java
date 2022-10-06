package utils;

import models.professional.ContractDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateDetails {
    public static ContractDetail createDetails(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int name = resultSet.getInt("contract_id");
        int cost = resultSet.getInt("attach_service_id");
        int quantity = resultSet.getInt("quantity");
        return new ContractDetail(id,name,cost,quantity);
    }
}
