package reposition.impl.employee;

import models.type.Division;
import reposition.ITypeRepository;
import service.ITypeService;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements ITypeRepository<Division> {
    public final String getDivision = "select * from division";
    @Override
    public List<Division> getList() {
        List<Division> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(getDivision)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new Division(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
