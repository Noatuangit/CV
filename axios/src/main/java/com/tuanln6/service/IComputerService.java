package com.tuanln6.service;

import com.tuanln6.dto.computer.ComputerDTO;
import com.tuanln6.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IComputerService {
    Page<Computer> findAllByCondition(String condition, Pageable pageable);

    Computer findById(String id);

    Integer updateStatusById(String status,String id);

    List<Computer> findAllNotStatusOffOrWaiting();

    Computer save(ComputerDTO computerDTO);

    List<Computer> findAll(String id);
}
