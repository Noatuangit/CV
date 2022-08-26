package service.impl.employee;

import models.type.Division;
import reposition.ITypeRepository;
import reposition.impl.employee.DivisionRepository;
import service.ITypeService;

import java.util.List;

public class DivisionService implements ITypeService<Division> {
    private ITypeRepository<Division> repository = new DivisionRepository();
    @Override
    public List<Division> getList() {
        return repository.getList();
    }
}
