package utils;

import models.person.Customer;
import models.person.Employee;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ConnectData {
    public static Connection getConnect() {
        String port = "jdbc:mysql://127.0.0.1/crud_servlet";
        Connection connection = null;
        String username = "";
        String password = "";
        boolean flag = true;
        String path = "D:\\CODEGYM\\user.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (flag) {
                    username = line;
                    flag = false;
                }
                password = line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(port, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }





}
