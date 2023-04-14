package com.java.service.impl;

import com.java.model.ServiceDetails;
import com.java.repos.IServiceDetailsRepos;
import com.java.repos.impl.ServiceDetailsReposImpl;
import com.java.service.IServiceDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDetailServiceImpl implements IServiceDetailService {
    IServiceDetailsRepos serviceDetailsRepos;

    public ServiceDetailServiceImpl(ServiceDetailsReposImpl serviceDetailsRepos) {
        this.serviceDetailsRepos = serviceDetailsRepos;
    }

    @Override
    public List<ServiceDetails> findAll(Integer page) {
        return serviceDetailsRepos.findAll(page);
    }

    @Override
    public long countQuery() {
        return serviceDetailsRepos.countQuery();
    }

    @Override
    public void removeByCustomerId(String id) {
        serviceDetailsRepos.removeByCustomerId(id);
    }

    @Override
    public void removeByServiceId(String id) {
        serviceDetailsRepos.removeByServiceId(id);
    }

    @Override
    public ServiceDetails save(ServiceDetails serviceDetails) {
        return serviceDetailsRepos.save(serviceDetails);
    }
}
