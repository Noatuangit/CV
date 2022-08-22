package service.impl;

import models.extra.Education;
import service.DTOType;
import utils.Query;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationService implements DTOType<Education> {
    @Override
    public void insertDTO(Education education) throws SQLException {
        // simple
    }

    @Override
    public List<Education> getList(String table) {
        List<Education> list = new ArrayList<>();
        try (Connection connection = Utils.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(Query.list_type.concat(table))) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new Education(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
