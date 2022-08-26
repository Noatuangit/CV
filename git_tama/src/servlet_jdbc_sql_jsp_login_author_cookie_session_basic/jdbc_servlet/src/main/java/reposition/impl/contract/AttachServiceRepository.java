package reposition.impl.contract;

import models.professional.AttachServiceAddOn;
import models.type.ServiceType;
import reposition.ITypeRepository;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository implements ITypeRepository<AttachServiceAddOn> {
    String getList = "select * from attach_service where attach_service_status = 'on'";

    @Override
    public List<AttachServiceAddOn> getList() {
        List<AttachServiceAddOn> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(getList)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("attach_service_cost");
                int unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                list.add(new AttachServiceAddOn(id, name, cost, unit, status));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
