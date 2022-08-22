package com.login_author_cookie_session.service;

import com.login_author_cookie_session.models.Fish;
import com.login_author_cookie_session.utils.InitTable;
import com.login_author_cookie_session.utils.QuerySelectTable;
import com.login_author_cookie_session.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FishService {


    public void addNew(Fish fish) {
        try (Connection connection = InitTable.getConnect();
             PreparedStatement statement = connection.prepareStatement(QuerySelectTable.addNewFish)) {
            statement.setInt(1, fish.getPrice());
            statement.setString(2, fish.getName());
            statement.setString(3, fish.getType());
            statement.setBoolean(4, fish.getGender());
            statement.setString(5, "Img/".concat(fish.getAvatar()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {

    }

    public void edit(int id) {

    }

    public List<Fish> getListFollow(String query, int MAX, int offset) {
        List<Fish> list = new ArrayList<>();
        try (Connection connection = InitTable.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, MAX);
            statement.setInt(2, offset * MAX);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Utils.createFishByResult(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int countListFollow(String query) {
        int count = 0;
        try (Connection connection = InitTable.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public Fish searchById(int id_search) {
        try (Connection connection = InitTable.getConnect();
             PreparedStatement statement = connection.prepareStatement(QuerySelectTable.searchFishById)) {
            statement.setInt(1, id_search);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
               return Utils.createFishByResult(set);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
