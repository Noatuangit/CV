package reposition.impl.customer;

import models.type.TypeCustomer;
import reposition.ITypeRepository;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeCustomerRepository implements ITypeRepository<TypeCustomer> {
    public final String type_customer_list = "select * from type_customer";

    @Override
    public List<TypeCustomer> getList() {
        List<TypeCustomer> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(type_customer_list)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new TypeCustomer(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
