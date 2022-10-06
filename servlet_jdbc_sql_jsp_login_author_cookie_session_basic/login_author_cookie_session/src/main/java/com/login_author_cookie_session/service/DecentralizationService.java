package com.login_author_cookie_session.service;

import com.login_author_cookie_session.utils.InitTable;
import com.login_author_cookie_session.utils.QuerySelectTable;
import com.login_author_cookie_session.models.Decentralization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DecentralizationService {
    List<Decentralization> list = new ArrayList<>();

    public static List<Decentralization> getList() {
        List<Decentralization> list = new ArrayList<>();
        try (Connection connection = InitTable.getConnect(); PreparedStatement statement = connection.prepareStatement(QuerySelectTable.Decentralization)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Decentralization(resultSet.getInt("id"), resultSet.getString("author")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static Decentralization getObject(int id) {
        String queryGetName = "select author from decentralization where id = ?";
        try (Connection connection = InitTable.getConnect(); PreparedStatement statement = connection.prepareStatement(queryGetName)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String result = resultSet.getString("author");
                return new Decentralization(id,result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
