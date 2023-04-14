package com.java.repos;

import com.java.model.ServiceDetails;

import java.util.List;

public interface IServiceDetailsRepos {
    List<ServiceDetails> findAll(Integer page);
    long countQuery();
    ServiceDetails save(ServiceDetails serviceDetails);
     void removeByCustomerId(String id);
    void removeByServiceId(String id);
}
