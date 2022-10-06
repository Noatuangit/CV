package service.impl.employee;

import models.type.Education;
import reposition.ITypeRepository;
import reposition.impl.employee.EducationRepository;
import service.ITypeService;

import java.util.List;

public class EducationService implements ITypeService<Education> {
    private final ITypeRepository<Education> repository = new EducationRepository();
    @Override
    public List<Education> getList() {
        return repository.getList();
    }
}
