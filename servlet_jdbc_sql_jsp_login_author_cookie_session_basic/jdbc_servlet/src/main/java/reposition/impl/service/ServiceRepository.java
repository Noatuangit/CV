package reposition.impl.service;

import models.person.Customer;
import models.professional.MainService;
import reposition.IBaseRepository;
import utils.ConnectData;
import utils.CreateCustomer;
import utils.CreateService;
import utils.FindAmountPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IBaseRepository<MainService> {
    public final int MAX_LIMIT_DISPLAY = 5;

    public final String insert_service = "INSERT INTO service (`name`, `area`, `service_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `facility_text`, `rent_type_id`, `service_type_id`) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    public final String list_service_offset = "SELECT * FROM service where `status` = 'on' order by id asc limit ? offset ?";


    public final String list_service_to_Contract = "select * from service";

    public final String update_service = "UPDATE service SET `name` = ?, `area` = ?, `service_cost` = ?, `max_people` = ?, `standard_room` = ?, `description_other_convenience` = ?, `pool_area` = ?, `number_of_floors` = ?, `facility_text` = ?, `rent_type_id` = ?, `service_type_id` = ? WHERE id = ?";

    public final String delete_service = "update service set `status` = 'off' where id = ?";

    public final String search_name_service = "select * from service where name regexp ?";

    public final String count_list = "select count(*) from service where `status` = 'on'";

    public final String search_service_by_id = "select * from service where id = ?";

    @Override
    public void save(MainService mainService) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(insert_service)) {
            CreateService.setValueInQuery(statement, mainService);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(MainService mainService, int id) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(update_service)) {
            statement.setInt(9, id);
            CreateService.setValueInQuery(statement, mainService);
            statement.executeUpdate();
        }
    }

    @Override
    public void removeById(int id) {
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(delete_service)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MainService> findByName(String name) {
        List<MainService> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement statement = connection.prepareStatement(search_name_service)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateService.createService(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public MainService findById(int id) {
        MainService mainService = null;
        try (Connection connection = ConnectData.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(search_service_by_id)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mainService = CreateService.createService(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mainService;
    }

    @Override
    public int countAmountFindAll() {
        return FindAmountPage.findAmountPage(count_list, MAX_LIMIT_DISPLAY);
    }

    @Override
    public List<MainService> getList(int offset, String query) {
        List<MainService> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(list_service_offset)) {
            statement.setInt(1, MAX_LIMIT_DISPLAY);
            statement.setInt(2, offset * MAX_LIMIT_DISPLAY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateService.createService(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<MainService> getList() {
        List<MainService> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(list_service_to_Contract)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateService.createService(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
