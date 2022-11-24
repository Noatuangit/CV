package com.example.demo.service.impl;

import com.example.demo.error.handleException.NotFoundEntityById;
import com.example.demo.models.HouseHold;
import com.example.demo.repos.IHouseHoldRepos;
import com.example.demo.service.IHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseHoldService implements IHouseHoldService {
    @Autowired
    IHouseHoldRepos repos;

    @Override
    public Page<HouseHold> findAll(String name_search, String address,String date_search, Pageable pageable) {
        return repos.findAll(name_search,address,date_search, pageable);
    }

    @Override
    public HouseHold save(HouseHold houseHold) {
        return repos.save(houseHold);
    }

    @Override
    public HouseHold findById(String id) throws NotFoundEntityById {
        Optional<HouseHold> optionalHouseHold = repos.findById(id);
        if (optionalHouseHold.isPresent()) {
            return optionalHouseHold.get();
        }
        throw new NotFoundEntityById("Not found any house hold in id = " + id);
    }


    @Override
    public void removeById(String id) {
        repos.deleteById(id);
    }

    @Override
    public void removeAllById(List<String> list) {
        list.forEach(this::removeById);
    }
}
