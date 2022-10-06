package com.example.demo.service.interface_business;


import com.example.demo.models.contract.ContractDetails;

public interface IContractDetailsService {
    ContractDetails save(ContractDetails details);

    Iterable<ContractDetails> findAll();
}

