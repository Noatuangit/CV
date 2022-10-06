package service.impl.employee;

import models.type.Position;
import reposition.ITypeRepository;
import reposition.impl.employee.PositionRepository;
import service.ITypeService;

import java.util.List;

public class PositionService implements ITypeService<Position> {
    private final ITypeRepository<Position> repository = new PositionRepository();
    @Override
    public List<Position> getList() {
        return repository.getList();
    }
}
