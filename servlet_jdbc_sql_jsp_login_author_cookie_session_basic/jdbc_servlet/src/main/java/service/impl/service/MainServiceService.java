package service.impl.service;

import models.professional.MainService;
import reposition.IBaseRepository;
import reposition.impl.service.ServiceRepository;
import service.IBaseService;
import utils.ValidData;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MainServiceService implements IBaseService<MainService> {
    private final IBaseRepository<MainService> repository = new ServiceRepository();


    @Override
    public Map<String, String> save(MainService mainService) throws SQLException {
        Map<String, String> mapError = ValidData.validData(mainService);
        if (mapError.isEmpty()) {
            repository.save(mainService);
        }
        return mapError;
    }

    @Override
    public Map<String, String> update(MainService mainService, int id) throws SQLException {
        Map<String, String> mapError = ValidData.validData(mainService);
        if (mapError.isEmpty()) {
            repository.update(mainService,id);
        }
        return mapError;
    }

    @Override
    public void removeById(int id) {
        repository.removeById(id);
    }

    @Override
    public List<MainService> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public MainService findById(int id) {
        return repository.findById(id);
    }

    @Override
    public int countAmountFindAll() {
        return repository.countAmountFindAll();
    }

    @Override
    public List<MainService> getList(int offset) {
        return repository.getList(offset,"");
    }

    @Override
    public List<MainService> getList() {
        return repository.getList();
    }

    @Override
    public List<MainService> getListHaveContract(int offset) {
        return null;
    }
}
