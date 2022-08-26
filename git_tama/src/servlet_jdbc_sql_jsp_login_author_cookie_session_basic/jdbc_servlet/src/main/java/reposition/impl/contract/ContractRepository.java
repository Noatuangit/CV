package reposition.impl.contract;

import models.person.Customer;
import models.professional.Contract;
import reposition.IBaseRepository;
import utils.ConnectData;
import utils.CreateContract;
import utils.CreateCustomer;
import utils.FindAmountPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IBaseRepository<Contract> {

    public final int MAX_LIMIT_DISPLAY = 5;

    public static final String insert_contract = "insert into contract (start_date, end_date, deposit, total_money, employee_id, customer_id, service_id) values (?,?,?,total_money_service(?),?,?,?)";

    public static final String list_contract_offset = "SELECT * FROM contract where `status` = 'on' order by id asc limit ? offset ?";

    public static final String update_contract = "update contract set start_date = ?, end_date =?, deposit=?, total_money = total_money_service(?), employee_id=?, customer_id=?, service_id=? where id = ?";

    public static final String delete_contract = "update contract set `status` = 'off' where id = ?";

    public static final String search_name_contract = "select * from contract where name regexp ?";

    public static final String count_list = "select count(*) from contract where `status` = 'on'";

    public static final String search_contract_by_id = "select * from contract where id = ?";

    @Override
    public void save(Contract contract) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(insert_contract)) {
            CreateContract.setValueInQuery(statement, contract);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Contract contract, int id) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(update_contract)) {
            statement.setInt(8, id);
            CreateContract.setValueInQuery(statement, contract);
            statement.executeUpdate();
        }
    }

    @Override
    public void removeById(int id) {
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(delete_contract)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Contract> findByName(String name) {
        List<Contract> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(search_name_contract)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateContract.createContract(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Contract findById(int id) {
        Contract contract = null;
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(search_contract_by_id)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contract = CreateContract.createContract(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }

    @Override
    public int countAmountFindAll() {
        return FindAmountPage.findAmountPage(count_list,MAX_LIMIT_DISPLAY);
    }

    @Override
    public List<Contract> getList(int offset , String query) {
        List<Contract> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(list_contract_offset)) {
            statement.setInt(1, MAX_LIMIT_DISPLAY);
            statement.setInt(2, offset * MAX_LIMIT_DISPLAY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateContract.createContract(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Contract> getList() {
        return null;
    }
}
