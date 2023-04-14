package com.java.repos;

import com.java.dto.ComDetailsDTO;
import com.java.model.ComputerDetails;

import java.util.List;

public interface IComputerDetailsRepos {
    List<ComputerDetails> findAll(Integer page);

    long countQuery();

    ComputerDetails save(ComputerDetails computerDetails);

    void removeByCustomerId(String customer_id);

    void removeByComputerID(String computer_id);

    void remove(ComDetailsDTO comDetailsDTO);

    List findAllServicePresent(Integer page);

    int countTotalService();
}
