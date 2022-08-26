package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindAmountPage {

    public static int findAmountPage(String query,int MAX_LIMIT_DISPLAY){
        int amount = 0;
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                amount = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) Math.ceil((float) amount / MAX_LIMIT_DISPLAY);
    }
}
