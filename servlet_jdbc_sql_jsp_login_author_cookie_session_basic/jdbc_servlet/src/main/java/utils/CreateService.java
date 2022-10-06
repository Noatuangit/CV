package utils;

import models.person.Customer;
import models.person.Employee;
import models.professional.MainService;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateService {
    public static void setValueInQuery(PreparedStatement statement, MainService service) throws SQLException {
        statement.setString(1, service.getName());
        statement.setInt(2, service.getArea());
        statement.setDouble(3, service.getCost());
        statement.setInt(4, service.getMax_people());
        statement.setString(5, service.getStandard_room());
        statement.setString(6, service.getDescription_other_convenience());
        statement.setDouble(7, service.getPool_area());
        statement.setInt(8, service.getNumber_of_floors());
        statement.setString(9, service.getFacility_text());
        statement.setInt(10, service.getRent_type());
        statement.setInt(11, service.getService_type());
    }

    public static MainService createService(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int area = resultSet.getInt("area");
        double cost = resultSet.getDouble("service_cost");
        int max_people = resultSet.getInt("max_people");
        String standard_room = resultSet.getString("standard_room");
        String description_other_convenience = resultSet.getString("description_other_convenience");
        double pool_area = resultSet.getDouble("pool_area");
        int number_of_floors = resultSet.getInt("number_of_floors");
        String facility_text = resultSet.getString("facility_text");
        int rent_type = resultSet.getInt("rent_type_id");
        int service_type = resultSet.getInt("service_type_id");
        return new MainService(id, name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_text, rent_type, service_type);
    }

    public static MainService createService(HttpServletRequest request) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int max_people = Integer.parseInt(request.getParameter("max_people"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
        String facility_text = request.getParameter("facility_text");
        int rent_type = Integer.parseInt(request.getParameter("rent"));
        int service_type = Integer.parseInt(request.getParameter("type"));
        return new MainService(name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_text, rent_type, service_type);
    }
}
