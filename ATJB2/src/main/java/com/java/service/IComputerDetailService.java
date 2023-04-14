package com.java.service;

import com.java.dto.ComDetailsDTO;
import com.java.model.ComputerDetails;

import java.util.List;

public interface IComputerDetailService {
    List<ComputerDetails> findAll(Integer page);
    long countQuery();
    ComputerDetails saveEntity(ComDetailsDTO comDetailsDTO);
    void removeByCustomerId(String customer_id);
    void removeByComputerID(String computer_id);
    void removeEntity(ComDetailsDTO comDetailsDTO);
    List findAllServicePresent(Integer page);
    long countTotalService();
}
