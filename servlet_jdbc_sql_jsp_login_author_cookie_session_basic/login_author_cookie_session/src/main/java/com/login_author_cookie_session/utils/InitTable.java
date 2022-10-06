package com.login_author_cookie_session.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitTable {
    public static String initTableFish = "CREATE TABLE IF NOT EXISTS Fish (id INT AUTO_INCREMENT PRIMARY KEY, price INT NOT NULL,  `name` VARCHAR(50) NOT NULL, `type` VARCHAR(50) NOT NULL, gender BOOLEAN, avatar varchar(200))";

    public static String initTableOrder = "create table if not exists order_fish (id int AUTO_INCREMENT PRIMARY KEY, fish_id int not null, account_username varchar(50) not null, amount int, total_money int, foreign key (fish_id) references Fish(id), foreign key (account_username) references accounts(username))";

    public static String initDecentralization = "create table if not exists decentralization (id int AUTO_INCREMENT PRIMARY KEY,author varchar(50))";

    public static String initAccount = "create table if not exists accounts (username varchar(50) primary key ,passwords varchar(50),decentralization_id int, foreign key(decentralization_id) references decentralization(id))";

    public static String insertDecentralization = "INSERT INTO decentralization (`id`, `author`) VALUES ('1', 'admin'),('2', 'newbie')";

    public static String insertAccount = "INSERT INTO accounts VALUES ('admin', 'admin',1),('newbie', 'newbie',2)";

    public static Connection getConnect() {
        String port = "jdbc:mysql://127.0.0.1/FishSell";
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
