package com.example.demo.service.impl.contract;

import com.example.demo.models.contract.Contract;
import com.example.demo.repos.contract.IContractRepository;
import com.example.demo.service.interface_business.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository repository;

    @Override
    public Page<Contract> findAllByName(String keyword, Pageable pageable) {
        return repository.findAllByName((keyword), pageable);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        repository.save(contract);
    }

    @Override
    public void updateById(Integer id_delete) {
        repository.updateById(id_delete);
    }

    @Override
    public void updateMoneyById(Integer id) {
        repository.updateMoneyById(id);
    }
}
