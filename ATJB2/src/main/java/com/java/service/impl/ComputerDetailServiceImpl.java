package com.java.service.impl;

import com.java.dto.ComDetailsDTO;
import com.java.model.ComputerDetails;
import com.java.repos.IComputerDetailsRepos;
import com.java.repos.impl.ComputerDetailsReposImpl;
import com.java.service.IComputerDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerDetailServiceImpl implements IComputerDetailService {
    IComputerDetailsRepos repos;

    public ComputerDetailServiceImpl(ComputerDetailsReposImpl computerDetailsRepos) {
        this.repos = computerDetailsRepos;
    }

    @Override
    public List<ComputerDetails> findAll(Integer page) {
        return repos.findAll(page);
    }

    @Override
    public long countQuery() {
        return repos.countQuery();
    }

    @Override
    public ComputerDetails saveEntity(ComDetailsDTO comDetailsDTO) {
        return repos.save(new ComputerDetails(comDetailsDTO));
    }

    @Override
    public void removeByCustomerId(String customer_id) {
        repos.removeByCustomerId(customer_id);
    }

    @Override
    public void removeByComputerID(String computer_id) {
        repos.removeByComputerID(computer_id);
    }

    @Override
    public void removeEntity(ComDetailsDTO comDetailsDTO) {
        repos.remove(comDetailsDTO);
    }

    @Override
    public List findAllServicePresent(Integer page) {
        return repos.findAllServicePresent(page);
    }

    @Override
    public long countTotalService() {
        return (long) Math.ceil(repos.countTotalService() / 5D);
    }
}
