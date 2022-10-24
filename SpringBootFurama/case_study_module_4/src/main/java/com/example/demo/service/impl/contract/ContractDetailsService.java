package com.example.demo.service.impl.contract;

import com.example.demo.models.contract.ContractDetails;
import com.example.demo.repos.contract.IContractDetailsRepository;
import com.example.demo.service.interface_business.IContractDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContractDetailsService implements IContractDetailsService {
    @Autowired
    IContractDetailsRepository repository;

    @Override
    public ContractDetails save(ContractDetails details) {
        return repository.save(details);
    }

    @Override
    public Iterable<ContractDetails> findAll() {
        return repository.findAll();
    }
}
