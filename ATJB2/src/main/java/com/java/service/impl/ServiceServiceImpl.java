package com.java.service.impl;

import com.java.model.AddService;
import com.java.repos.IServiceRepos;
import com.java.repos.impl.ServiceReposImpl;
import com.java.service.IServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements IServiceService {
    IServiceRepos serviceRepos;

    public ServiceServiceImpl(ServiceReposImpl serviceRepos) {
        this.serviceRepos = serviceRepos;
    }

    @Override
    public List<AddService> findAllByName(String name, Integer page) {
        return serviceRepos.findAllByName(name, page);
    }

    @Override
    public AddService findById(String id) {
        return serviceRepos.findById(id);
    }

    @Override
    public void save(AddService addService) {
          serviceRepos.save(addService);
    }

    @Override
    public void updateById(String id) {
        serviceRepos.updateById(id);
    }

    @Override
    public Integer countFindAllByName(String name) {
        return serviceRepos.countFindAllByName(name);
    }

    @Override
    public List<AddService> findAll() {
        return serviceRepos.findAll();
    }


}
