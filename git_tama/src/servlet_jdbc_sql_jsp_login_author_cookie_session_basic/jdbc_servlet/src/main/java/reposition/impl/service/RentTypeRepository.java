package reposition.impl.service;

import models.type.RentType;
import reposition.ITypeRepository;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements ITypeRepository<RentType> {

    public final String getRentType = "select * from rent_type";

    @Override
    public List<RentType> getList() {
        List<RentType> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(getRentType)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("rent_type_cost");
                list.add(new RentType(id, name, cost));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
