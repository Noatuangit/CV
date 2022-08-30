package reposition.impl.customer;

import models.person.Customer;
import reposition.IBaseRepository;
import utils.ConnectData;
import utils.CreateCustomer;
import utils.FindAmountPage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IBaseRepository<Customer> {

    public static final int MAX_LIMIT_DISPLAY = 5;

    public static final String insert_customer = "INSERT INTO customer (`type_customer_id`, `name`, `birthday`, `id_card`, `gender`, `phone`, `email`, `address`) " +
            "VALUES (?,?,?,?,?,?,?,?)";

    public static final String list_customer_offset = "SELECT * FROM customer where `status` = 'on' order by id asc limit ? offset ?";


    public static final String list_customer_to_Contract = "select * from customer";

    public static final String update_customer = "UPDATE customer SET `type_customer_id` = ?, `name` = ?, `birthday` = ?, `id_card` = ?, `gender` = ?, `phone` = ?, `email` = ?, `address` = ? WHERE id = ?";

    public static final String delete_customer = "update customer set `status` = 'off' where id = ?";

    public static final String search_name_customer = "select * from customer where name regexp ?";

    public static final String count_list = "select count(*) from customer where `status` = 'on'";

    public static final String count_list_have_contract = "select count(*) from customer where id in (select customer_id from contract)";

    public static final String search_customer_by_id = "select * from customer where id = ?";

    public static final String list_customer_have_contract = "select customer.id, type_customer_id, `name`, birthday, id_card, gender, phone, email, address, customer.`status` from customer inner join contract on contract.customer_id = customer.id group by customer.id limit ? offset ?";

    @Override
    public void save(Customer customer) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(insert_customer)) {
            CreateCustomer.setValueInQuery(statement, customer);
            statement.executeUpdate();
        }
    }


    @Override
    public void update(Customer customer, int id) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(update_customer)) {
            statement.setInt(9, id);
            CreateCustomer.setValueInQuery(statement, customer);
            statement.executeUpdate();
        }
    }


    @Override
    public void removeById(int id) {
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(delete_customer)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(search_name_customer)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateCustomer.createCustomer(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(search_customer_by_id)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = CreateCustomer.createCustomer(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public int countAmountFindAll() {
        return FindAmountPage.findAmountPage(count_list,MAX_LIMIT_DISPLAY);
    }

    @Override
    public List<Customer> getList(int offset,String query) {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, MAX_LIMIT_DISPLAY);
            statement.setInt(2, offset * MAX_LIMIT_DISPLAY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateCustomer.createCustomer(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


    @Override
    public List<Customer> getList   () {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(list_customer_to_Contract)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateCustomer.createCustomer(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
