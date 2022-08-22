package repository;

import models.professional_furama.AttachService;
import service.DTOType;
import utils.Query;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceControl implements DTOType<AttachService> {
    @Override
    public void insertDTO(AttachService attachService) throws SQLException {
        // simple
    }

    @Override
    public List<AttachService> getList(String table) {
        List<AttachService> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement statement = connection.prepareStatement(Query.list_type.concat(table))) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("attach_service_cost");
                int unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                list.add(new AttachService(id, name, cost, unit, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
