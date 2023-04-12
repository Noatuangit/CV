package com.tuanln6.service;

import com.tuanln6.dto.view.ServiceViewDetailsDTO;
import com.tuanln6.model.ServiceDetails;
import com.tuanln6.model.id.ServiceDetailsID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceDetailsService {
    Page<ServiceViewDetailsDTO> findAll(String condition ,Pageable pageable);

    ServiceViewDetailsDTO save(ServiceDetails serviceDetails);

    ServiceDetails findById(ServiceDetailsID serviceDetailsID);

    void removeById(ServiceDetailsID serviceDetailsID);

    void removeByCustomerId(String id);

    void removeByServiceId(String id);

    Page<String[]> findAllTotal( Pageable pageable);
}
