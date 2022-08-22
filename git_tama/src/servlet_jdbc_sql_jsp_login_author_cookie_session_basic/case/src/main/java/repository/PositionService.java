package repository;

import models.extra.Position;
import models.extra.TypeCustomer;
import service.DTOType;
import utils.Query;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionService implements DTOType<Position> {
    @Override
    public void insertDTO(Position position) throws SQLException {

    }

    @Override
    public List<Position> getList(String table) {
        List<Position> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(Query.list_type.concat(table))) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new Position(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
