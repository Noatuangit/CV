package service.impl.customer;

import models.type.TypeCustomer;
import reposition.ITypeRepository;
import reposition.impl.customer.TypeCustomerRepository;
import service.ITypeService;

import java.util.List;

public class TypeCustomerService implements ITypeService<TypeCustomer> {
    private final ITypeRepository<TypeCustomer> typeRepository = new TypeCustomerRepository();
    @Override
    public List<TypeCustomer> getList() {
        return typeRepository.getList();
    }
}
