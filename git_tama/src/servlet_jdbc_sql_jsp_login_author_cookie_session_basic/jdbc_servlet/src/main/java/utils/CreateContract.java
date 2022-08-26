package utils;

import models.professional.Contract;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CreateContract {
    public static Contract createContract(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        Timestamp start_day = resultSet.getTimestamp("start_date");
        Timestamp end_day = resultSet.getTimestamp("end_date");
        double deposit = resultSet.getDouble("deposit");
        int employee_id = resultSet.getInt("employee_id");
        int customer_id = resultSet.getInt("customer_id");
        int service_id = resultSet.getInt("service_id");
        double total_money = resultSet.getDouble("total_money");
        return new Contract(id, start_day, end_day, deposit, employee_id, customer_id, service_id, total_money);
    }

    public static Contract createContract(HttpServletRequest request) throws SQLException {
        Timestamp start_date = Timestamp.valueOf(request.getParameter("start_date").replace("T", " ").concat(":00"));
        Timestamp end_date = Timestamp.valueOf(request.getParameter("end_date").replace("T", " ").concat(":00"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        int customers = Integer.parseInt(request.getParameter("customers"));
        int employees = Integer.parseInt(request.getParameter("employees"));
        int services = Integer.parseInt(request.getParameter("services"));
        return new Contract(start_date, end_date, deposit, employees, customers, services);
    }

    public static void setValueInQuery(PreparedStatement statement, Contract contract) throws SQLException {
        statement.setTimestamp(1, contract.getStart_day());
        statement.setTimestamp(2, contract.getEnd_day());
        statement.setDouble(3, contract.getDeposit());
        statement.setInt(4, contract.getService_id());
        statement.setInt(5, contract.getEmployee_id());
        statement.setInt(6,contract.getCustomer_id());
        statement.setInt(7, contract.getService_id());
//        update contract set start_date = ?, end_date =?, deposit=?, total_money = total_money_service(?), employee_id=?, customer_id=?, service_id=? where id = ?
    }
}
