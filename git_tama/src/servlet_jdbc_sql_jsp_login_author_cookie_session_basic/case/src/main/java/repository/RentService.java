package repository;

import models.extra.RentType;
import service.DTOType;
import utils.Query;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentService implements DTOType<RentType> {
    @Override
    public void insertDTO(RentType rentType) throws SQLException {
        // simple

    }

    @Override
    public List<RentType> getList(String table) {
        List<RentType> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(Query.list_type.concat(table))) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("rent_type_cost");
                list.add(new RentType(id, name, cost));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
