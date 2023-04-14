package com.java.repos;


import com.java.model.Computer;

import java.util.List;

public interface IComputerRepos{
    List<Computer> findAllByPositionAndStatus(String position, String status, Integer page);

    void save(Computer computer);

    long countQuery(String position, String status);

    List<Computer> findAllByStatusNotWaiting();

    void updateStatusById(String status, String computer_id);
}
