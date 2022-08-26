package utils;

import models.person.Customer;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateCustomer {
    public static Customer createCustomer(HttpServletRequest request) {
        int customer_type = Integer.parseInt(request.getParameter("customer_type"));
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        return new Customer(customer_type, name, birthday, gender, id_card, phone, email, address);
    }

    public static Customer createCustomer(ResultSet re) throws SQLException {
        int id = re.getInt("id");
        int customer_type = re.getInt("type_customer_id");
        String name = re.getString("name");
        Date birthday = re.getDate("birthday");
        int gender = re.getInt("gender");
        String id_card = re.getString("id_card");
        String phone = re.getString("phone");
        String email = re.getString("email");
        String address = re.getString("address");
        return new Customer(id, customer_type, name, birthday, gender, id_card, phone, email, address);
    }

    public static void setValueInQuery(PreparedStatement statement, Customer customer) throws SQLException {
        statement.setInt(1, customer.getCustomer_type());
        statement.setString(2, customer.getName());
        statement.setDate(3, customer.getBirthday());
        statement.setString(4, customer.getId_card());
        statement.setByte(5, (byte) customer.getGender());
        statement.setString(6, customer.getPhone());
        statement.setString(7, customer.getEmail());
        statement.setString(8, customer.getAddress());
    }
}

