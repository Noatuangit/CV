package com.login_author_cookie_session.service;

import com.login_author_cookie_session.models.Account;
import com.login_author_cookie_session.models.Decentralization;
import com.login_author_cookie_session.utils.InitTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    List<Account> list = new ArrayList<>();

    String selectAccount = "select * from accounts where username = ? and passwords = ?";

    public void insertAccount() {

    }

    public boolean isExistsAccount(String username, String password) {
        try (Connection connection = InitTable.getConnect(); PreparedStatement statement = connection.prepareStatement(selectAccount)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public Account selectAccountByName(String username, String password) {
        try (Connection connection = InitTable.getConnect(); PreparedStatement statement = connection.prepareStatement(selectAccount)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString("username");
                String pass = resultSet.getString("passwords");
                Decentralization author = DecentralizationService.getObject(resultSet.getInt("decentralization_id"));
                return new Account(name,pass,author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
