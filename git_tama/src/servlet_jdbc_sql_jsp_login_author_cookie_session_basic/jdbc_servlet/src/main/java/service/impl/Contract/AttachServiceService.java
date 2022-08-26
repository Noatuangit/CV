package service.impl.Contract;

import models.professional.AttachServiceAddOn;
import reposition.ITypeRepository;
import reposition.impl.contract.AttachServiceRepository;
import service.ITypeService;

import java.util.List;

public class AttachServiceService implements ITypeService<AttachServiceAddOn> {
    private ITypeRepository<AttachServiceAddOn> repository = new AttachServiceRepository();

    @Override
    public List<AttachServiceAddOn> getList() {
        return repository.getList();
    }
}
