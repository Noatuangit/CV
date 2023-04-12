package com.tuanln6.service;

import com.tuanln6.dto.service.ServiceDTO;
import com.tuanln6.model.AddOnService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    Page<AddOnService> findAllByCondition(String condition, Pageable pageable);

    List<AddOnService> findAll();

    AddOnService findById(String id);

    Integer updateStatusById(String id);

    AddOnService save(ServiceDTO serviceDTO);
}
