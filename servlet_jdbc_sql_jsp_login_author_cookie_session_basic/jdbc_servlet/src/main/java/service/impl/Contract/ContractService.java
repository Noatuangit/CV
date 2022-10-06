package service.impl.Contract;

import models.professional.Contract;
import reposition.IBaseRepository;
import reposition.impl.contract.ContractRepository;
import service.IBaseService;
import utils.ValidData;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ContractService implements IBaseService<Contract> {
    private final IBaseRepository<Contract> repository = new ContractRepository();

    @Override
    public Map<String, String> save(Contract contract) throws SQLException {
        Map<String, String> mapError = ValidData.validData(contract);
        if (mapError.isEmpty()) {
            repository.save(contract);
        }
        return mapError;
    }

    @Override
    public Map<String, String> update(Contract contract, int id) throws SQLException {
        Map<String, String> mapError = ValidData.validData(contract);
        if (mapError.isEmpty()) {
            repository.update(contract, id);
        }
        return mapError;
    }

    @Override
    public void removeById(int id) {
        repository.removeById(id);
    }

    @Override
    public List<Contract> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Contract findById(int id) {
        return repository.findById(id);
    }

    @Override
    public int countAmountFindAll() {
        return repository.countAmountFindAll();
    }

    @Override
    public List<Contract> getList(int offset) {
        return repository.getList(offset,"");
    }

    @Override
    public List<Contract> getList() {
        return null;
    }

    @Override
    public List<Contract> getListHaveContract(int offset) {
        return null;
    }
}
