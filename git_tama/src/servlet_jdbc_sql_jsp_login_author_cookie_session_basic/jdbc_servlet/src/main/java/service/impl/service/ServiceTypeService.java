package service.impl.service;

import models.type.ServiceType;
import reposition.ITypeRepository;
import reposition.impl.service.ServiceTypeRepository;
import service.ITypeService;

import java.util.List;

public class ServiceTypeService implements ITypeService<ServiceType> {
    private final ITypeRepository<ServiceType> repository = new ServiceTypeRepository();
    @Override
    public List<ServiceType> getList() {
        return repository.getList();
    }
}
