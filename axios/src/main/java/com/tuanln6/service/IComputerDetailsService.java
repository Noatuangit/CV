package com.tuanln6.service;

import com.tuanln6.dto.view.ComputerViewDetailsDTO;
import com.tuanln6.model.ComputerDetails;
import com.tuanln6.model.id.ComputerDetailsID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IComputerDetailsService {
    Page<ComputerViewDetailsDTO> findAll(String condition ,Pageable pageable);

    ComputerDetails save(ComputerDetails computerDetails);

    ComputerDetails findById(ComputerDetailsID computerDetailsID);

    void removeById(ComputerDetailsID computerDetailsID);

    void removeByCustomerId(String id);

    void removeByComputerId(String id);
}
