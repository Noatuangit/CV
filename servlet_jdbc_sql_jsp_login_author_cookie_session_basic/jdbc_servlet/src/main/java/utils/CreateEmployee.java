package utils;

import models.person.Customer;
import models.person.Employee;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateEmployee {

    public static Employee createEmployee(HttpServletRequest request) {
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String id_card = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String positions = request.getParameter("positions");
        String education_degree = request.getParameter("educations");
        String division = request.getParameter("divisions");
        return new Employee(name, birthday, id_card, salary, phone, email, address, Integer.parseInt(positions), Integer.parseInt(education_degree), Integer.parseInt(division));
    }

    public static Employee createEmployee(ResultSet re) throws SQLException {
        int id =re.getInt("id");
        String name = re.getString("name");
        Date birthday = re.getDate("birthday");
        String id_card = re.getString("id_card");
        double salary = re.getDouble("salary");
        String phone = re.getString("phone");
        String email = re.getString("email");
        String address = re.getString("address");
        String positions = re.getString("position_id");
        String education_degree = re.getString("education_degree_id");
        String division = re.getString("division_id");
        return new Employee(id, name, birthday, id_card, salary, phone, email, address, Integer.parseInt(positions), Integer.parseInt(education_degree), Integer.parseInt(division));
    }
    public static void setValueInQuery(PreparedStatement statement, Employee employee) throws SQLException {
        statement.setString(1, employee.getName());
        statement.setDate(2, employee.getBirthday());
        statement.setString(3, employee.getId_card());
        statement.setDouble(4, employee.getSalary());
        statement.setString(5, employee.getPhone());
        statement.setString(6, employee.getEmail());
        statement.setString(7, employee.getAddress());
        statement.setInt(8, employee.getPositions());
        statement.setInt(9, employee.getEducation_degree());
        statement.setInt(10, employee.getDivision());
    }
}
