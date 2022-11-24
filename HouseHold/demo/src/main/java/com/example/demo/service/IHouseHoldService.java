package com.example.demo.service;

import com.example.demo.error.handleException.NotFoundEntityById;
import com.example.demo.models.HouseHold;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IHouseHoldService {
    Page<HouseHold> findAll( String name_search,String address_search,String date_search, Pageable pageable);

    HouseHold save(HouseHold houseHold);

    HouseHold findById(String id) throws NotFoundEntityById;

    void removeById(String id);

    void removeAllById(List<String> list);
}
