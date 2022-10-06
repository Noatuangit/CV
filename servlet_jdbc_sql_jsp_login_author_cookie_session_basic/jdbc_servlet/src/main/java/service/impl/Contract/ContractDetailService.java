package service.impl.Contract;

import models.professional.ContractDetail;
import reposition.IContractDetailsRepository;
import reposition.impl.contract.ContractDetailRepository;
import service.IContractDetailService;

import java.util.List;

public class ContractDetailService implements IContractDetailService<ContractDetail> {
    private final IContractDetailsRepository<ContractDetail> contractDetailITypeRepository = new ContractDetailRepository();

    @Override
    public List<ContractDetail> getList() {
        return contractDetailITypeRepository.getList();
    }

    @Override
    public void insertDetail(ContractDetail contractDetail) {
        contractDetailITypeRepository.insertDetail(contractDetail);
    }

    @Override
    public List<ContractDetail> searchListContractDetailById(int id) {
        return contractDetailITypeRepository.searchListContractDetailById(id);
    }
}
