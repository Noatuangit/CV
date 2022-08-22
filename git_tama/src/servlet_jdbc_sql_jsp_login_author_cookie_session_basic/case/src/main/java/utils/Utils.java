package utils;

import models.professional_furama.Contract;
import models.professional_furama.ContractDetail;
import models.professional_furama.Service;
import models.person.Customer;
import models.person.Employee;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Utils {
    public static Connection getConnect() {
        String port = "jdbc:mysql://127.0.0.1/case_study_m3";
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


    public static String getGender(int id) {
        return id == 1 ? "Male" : "Female";
    }

    public static Customer createCustomer(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String customer_type = request.getParameter("customer_type");
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String gender = request.getParameter("gender");
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        return new Customer(id, customer_type, name, birthday, gender, id_card, phone, email, address);
    }

    public static Customer createCustomer(ResultSet re) throws SQLException {
        int id = re.getInt("id");
        String customer_type = re.getString("type_customer_id");
        String name = re.getString("name");
        Date birthday = re.getDate("birthday");
        String gender = re.getString("gender");
        String id_card = re.getString("id_card");
        String phone = re.getString("phone");
        String email = re.getString("email");
        String address = re.getString("address");
        return new Customer(id, customer_type, name, birthday, gender, id_card, phone, email, address);
    }

    public static Employee createEmployee(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
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
        return new Employee(id, name, birthday, id_card, salary, phone, email, address, positions, education_degree, division);
    }

    public static Employee createEmployee(ResultSet re) throws SQLException {
        int id = re.getInt("id");
        String name = re.getString("name");
        Date birthday = re.getDate("birthday");
        String id_card = re.getString("id_card");
        double salary = (re.getDouble("salary"));
        String phone = re.getString("phone");
        String email = re.getString("email");
        String address = re.getString("address");
        String positions = re.getString("position_id");
        String education_degree = re.getString("education_degree_id");
        String division = re.getString("division_id");
        return new Employee(id, name, birthday, id_card, salary, phone, email, address, positions, education_degree, division);
    }

    public static Service searchService(ResultSet resultSet) throws SQLException {
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
        String rent_type = resultSet.getString("rent_type_id");
        String service_type = resultSet.getString("service_type_id");
        return new Service(id, name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_text, rent_type, service_type);
    }

    public static Service createService(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int max_people = Integer.parseInt(request.getParameter("max_people"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
        String facility_text = request.getParameter("facility_text");
        String rent_type = request.getParameter("rent");
        String service_type = request.getParameter("type");
        return new Service(id, name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors, facility_text, rent_type, service_type);
    }

    public static Contract createContract(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        Timestamp start_day = resultSet.getTimestamp("start_date");
        Timestamp end_day = resultSet.getTimestamp("end_date");
        double deposit = resultSet.getDouble("deposit");
        String employee_id = resultSet.getString("employee_id");
        String customer_id = resultSet.getString("customer_id");
        String service_id = resultSet.getString("service_id");
        double total_money = resultSet.getDouble("total_money");
        return new Contract(id, start_day, end_day, deposit, employee_id, customer_id, service_id, total_money);
    }

    public static Contract createContractName(ResultSet resultSet) throws SQLException {
        int id = (resultSet.getInt("id"));
        Timestamp start_day = resultSet.getTimestamp("start_date");
        Timestamp end_day = resultSet.getTimestamp("end_date");
        double deposit = resultSet.getDouble("deposit");
        String employee_id = resultSet.getString("en");
        String customer_id = resultSet.getString("cn");
        String service_id = resultSet.getString("sn");
        double total_money = resultSet.getDouble("total_money");
        return new Contract(id, start_day, end_day, deposit, employee_id, customer_id, service_id, total_money);
    }

    public static Contract createContract(HttpServletRequest request) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Timestamp start_day = Timestamp.valueOf(request.getParameter("start_date"));
        Timestamp end_day = Timestamp.valueOf(request.getParameter("end_date"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        String employee_id = request.getParameter("employee_id");
        String customer_id = request.getParameter("customer_id");
        String service_id = request.getParameter("service_id");
        double total_money = Double.parseDouble(request.getParameter("total_money"));
        return new Contract(id, start_day, end_day, deposit, employee_id, customer_id, service_id, total_money);
    }

    public static ContractDetail createContractDetails(ResultSet resultSet) throws SQLException {
        int id_contract = resultSet.getInt("contract_id");
        int id_details = resultSet.getInt("id");
        int id_attach_service = resultSet.getInt("attach_service_id");
        int quantity = resultSet.getInt("quantity");
        return new ContractDetail(id_details, id_contract, id_attach_service, quantity);
    }

    public static ContractDetail createContractDetails(HttpServletRequest request) throws SQLException {
        int id_contract = Integer.parseInt(request.getParameter("id_contract"));
        int id_details = Integer.parseInt(request.getParameter("id_details"));
        int id_attach_service = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        return new ContractDetail(id_details, id_contract, id_attach_service, quantity);
    }
}
