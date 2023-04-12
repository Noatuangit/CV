package com.tuanln6.service.impl;

import com.tuanln6.dto.computer.ComputerDTO;
import com.tuanln6.error.exception.NotFoundException;
import com.tuanln6.model.Computer;
import com.tuanln6.repos.IComputerRepos;
import com.tuanln6.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements IComputerService {
    @Autowired
    IComputerRepos repos;

    @Override
    public Page<Computer> findAllByCondition(String condition, Pageable pageable) {
        return repos.findAllByPositionContainingOrderByPosition(condition, pageable);
    }

    @Override
    public Computer findById(String id) {
        Optional<Computer> optionalComputer = repos.findById(id);
        if (optionalComputer.isPresent()) {
            return optionalComputer.get();
        }
        throw new NotFoundException("Server not found computer with id " + id);
    }

    @Override
    public Integer updateStatusById(String status, String id) {
        return repos.updateStatusById(id,status);
    }

    @Override
    public List<Computer> findAllNotStatusOffOrWaiting() {
        return repos.findAllByStatusNotIn(Arrays.asList("off", "waiting"));
    }

    @Override
    public List<Computer> findAll(String id) {
        return repos.findAllByStatusNotInOrId(Arrays.asList("off", "waiting"),id);
    }

    @Override
    public Computer save(ComputerDTO computerDTO) {
        return repos.save(new Computer(computerDTO));
    }
}
