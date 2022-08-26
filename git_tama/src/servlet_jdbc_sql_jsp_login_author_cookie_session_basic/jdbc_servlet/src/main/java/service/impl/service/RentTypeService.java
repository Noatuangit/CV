package service.impl.service;

import models.type.RentType;
import reposition.ITypeRepository;
import reposition.impl.service.RentTypeRepository;
import service.ITypeService;

import java.util.List;

public class RentTypeService implements ITypeService<RentType> {
    private final ITypeRepository<RentType> rentTypeIBaseRepository = new RentTypeRepository();

    @Override
    public List<RentType> getList() {
        return rentTypeIBaseRepository.getList();
    }
}
