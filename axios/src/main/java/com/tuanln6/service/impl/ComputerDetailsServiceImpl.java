package com.tuanln6.service.impl;

import com.tuanln6.dto.view.ComputerViewDetailsDTO;
import com.tuanln6.error.exception.NotFoundException;
import com.tuanln6.model.ComputerDetails;
import com.tuanln6.model.id.ComputerDetailsID;
import com.tuanln6.repos.IComputerDetailsRepos;
import com.tuanln6.service.IComputerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerDetailsServiceImpl implements IComputerDetailsService {
    @Autowired
    IComputerDetailsRepos repos;

    @Override
    public Page<ComputerViewDetailsDTO> findAll(String condition ,Pageable pageable) {
        return repos.findAllByCustomerNameOrIdComputer(condition,pageable).map(ComputerViewDetailsDTO::new);
    }

    @Override
    public ComputerDetails save(ComputerDetails computerDetails) {
        return repos.save(computerDetails);
    }

    @Override
    public ComputerDetails findById(ComputerDetailsID computerDetailsID) {
        Optional<ComputerDetails> computerDetails = repos.findById(computerDetailsID);
        if (computerDetails.isPresent()) {
            return computerDetails.get();
        }
        throw new NotFoundException("Server not found service of computer with this id ");
    }

    @Override
    public void removeById(ComputerDetailsID computerDetailsID) {
        repos.deleteById(computerDetailsID);
    }

    @Override
    public void removeByCustomerId(String id) {
        repos.deleteByCustomerId(id);
    }

    @Override
    public void removeByComputerId(String id) {
        repos.deleteByComputerId(id);
    }
}
