package reposition.impl.service;

import models.type.Position;
import models.type.ServiceType;
import reposition.ITypeRepository;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements ITypeRepository<ServiceType> {
    public final String getServiceType = "SELECT * FROM service_type";

    @Override
    public List<ServiceType> getList() {
        List<ServiceType> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(getServiceType)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new ServiceType(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
