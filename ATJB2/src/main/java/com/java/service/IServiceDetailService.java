package com.java.service;

import com.java.model.ServiceDetails;

import java.util.List;

public interface IServiceDetailService {
    List<ServiceDetails> findAll(Integer page);

    long countQuery();

    void removeByCustomerId(String id);

    void removeByServiceId(String id);

    ServiceDetails save(ServiceDetails serviceDetails);
}
