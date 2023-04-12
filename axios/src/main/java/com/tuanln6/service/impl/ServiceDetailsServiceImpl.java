package com.tuanln6.service.impl;

import com.tuanln6.dto.view.ServiceViewDetailsDTO;
import com.tuanln6.error.exception.NotFoundException;
import com.tuanln6.model.ServiceDetails;
import com.tuanln6.model.id.ServiceDetailsID;
import com.tuanln6.repos.IServiceDetailsRepos;
import com.tuanln6.service.IServiceDetailsService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceDetailsServiceImpl implements IServiceDetailsService {
    @Autowired
    IServiceDetailsRepos repos;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Page<ServiceViewDetailsDTO> findAll(String condition, Pageable pageable) {
        return repos.findAllByCondition(condition,pageable).map(ServiceViewDetailsDTO::new);
    }

    @Override
    public ServiceViewDetailsDTO save(ServiceDetails serviceDetails) {
        return new ServiceViewDetailsDTO(repos.save(serviceDetails));
    }

    @Override
    public ServiceDetails findById(ServiceDetailsID serviceDetailsID) {
        Optional<ServiceDetails> serviceDetails = repos.findById(serviceDetailsID);
        if (serviceDetails.isPresent()) {
            return serviceDetails.get();
        }
        throw new NotFoundException("Server not found service details with this id ");
    }

    @Override
    public void removeById(ServiceDetailsID serviceDetailsID) {
        repos.deleteById(serviceDetailsID);
    }

    @Override
    public void removeByCustomerId(String id) {
        repos.deleteByCustomerId(id);
    }

    @Override
    public void removeByServiceId(String id) {
        repos.removeByServiceId(id);
    }

    @Override
    public Page<String[]> findAllTotal( Pageable pageable) {
        return repos.findAllTotal( pageable);
    }
}
