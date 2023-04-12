package com.tuanln6.service.impl;

import com.tuanln6.dto.service.ServiceDTO;
import com.tuanln6.error.exception.NotFoundException;
import com.tuanln6.model.AddOnService;
import com.tuanln6.repos.IServiceRepos;
import com.tuanln6.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements IServiceService {
    @Autowired
    IServiceRepos serviceRepos;

    @Override
    public Page<AddOnService> findAllByCondition(String condition, Pageable pageable) {
        return serviceRepos.findAllByStatusAndNameContainingOrUnitContaining("on", condition, condition, pageable);
    }

    @Override
    public List<AddOnService> findAll() {
        return serviceRepos.findAllByStatusNot("off");
    }

    @Override
    public AddOnService findById(String id) {
        Optional<AddOnService> service = serviceRepos.findById(id);
        if (service.isPresent()) {
            return service.get();
        }
        throw new NotFoundException("AddOnService not found service with id " + id);
    }

    @Override
    public Integer updateStatusById(String id) {
        return serviceRepos.updateStatusById(id);
    }

    @Override
    public AddOnService save(ServiceDTO serviceDTO) {
        return serviceRepos.save(new AddOnService(serviceDTO));
    }
}
