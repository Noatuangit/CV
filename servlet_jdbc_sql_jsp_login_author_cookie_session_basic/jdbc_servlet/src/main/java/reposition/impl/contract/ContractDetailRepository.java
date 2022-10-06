package reposition.impl.contract;

import models.professional.ContractDetail;
import reposition.IContractDetailsRepository;
import utils.ConnectData;
import utils.CreateDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailsRepository<ContractDetail> {
    String getList = "select * from contract_details";

    String insert_contract_details = "INSERT INTO contract_details (`contract_id`, `attach_service_id`, `quantity`) VALUES (?, ?, ?)";

    String search_contract_details = "select * from contract_details where contract_id = ? ";


    @Override
    public List<ContractDetail> getList() {
        List<ContractDetail> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(getList)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(CreateDetails.createDetails(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void insertDetail(ContractDetail contractDetail) {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(insert_contract_details)) {
            statement.setInt(1, contractDetail.getId_contract());
            statement.setInt(2, contractDetail.getId_attach_service());
            statement.setInt(3, contractDetail.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ContractDetail> searchListContractDetailById(int id) {
        List<ContractDetail> contractDetail = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(search_contract_details)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contractDetail.add(CreateDetails.createDetails(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contractDetail;
    }
}
