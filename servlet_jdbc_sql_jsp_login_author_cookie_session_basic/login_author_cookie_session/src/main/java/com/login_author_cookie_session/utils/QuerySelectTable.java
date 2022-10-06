package com.login_author_cookie_session.utils;

public class QuerySelectTable {
    public static String Decentralization = "select * from decentralization";

    public static String Account = "select * from accounts";
    public static String Fish = "select * from fish limit ? offset ?";
    public static String countFish = "select count(*) from fish";

    public static String addNewFish = "insert into fish (price, name, type, gender, avatar) values (?,?,?,?,?)";

    public static String searchFishById = "select * from fish where id = ?";
}
