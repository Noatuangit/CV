package reposition.impl.employee;

import models.type.Division;
import models.type.Education;
import reposition.ITypeRepository;
import service.ITypeService;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepository implements ITypeRepository<Education> {
    public final String getEducationDegree = "select * from education_degree";
    @Override
    public List<Education> getList() {
        List<Education> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(getEducationDegree)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new Education(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
