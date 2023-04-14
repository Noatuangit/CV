package com.java.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.model.Computer;
import com.java.repos.IComputerRepos;
import com.java.repos.impl.ComputerReposImpl;
import com.java.service.IComputerService;

@Service
public class ComputerServiceImpl implements IComputerService {
    IComputerRepos repos;

    public ComputerServiceImpl(ComputerReposImpl computerRepos) {
        this.repos = computerRepos;
    }

    @Override
    public List<Computer> findAllByPositionAndStatus(String position, String status, Integer page) {
        return repos.findAllByPositionAndStatus(position, status, page);
    }

    @Override
    public void save(Computer computer) {
        repos.save(computer);
    }

    @Override
    public long countQuery(String position, String status) {
        return repos.countQuery(position, status);
    }


    @Override
    public List<Computer> findAllByStatusNotWaiting() {
        return repos.findAllByStatusNotWaiting();
    }

    @Override
    public void updateStatusById(String status, String computer_id) {
        repos.updateStatusById(status,computer_id);
    }
}
 