package com.example.demo.repos.contract;

import com.example.demo.models.contract.ContractDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface IContractDetailsRepository extends JpaRepository<ContractDetails, Integer> {
}
