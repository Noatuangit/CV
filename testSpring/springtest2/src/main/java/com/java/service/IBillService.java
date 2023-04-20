package com.java.service;

import com.java.dto.BillDTO;
import com.java.model.Bill;

import java.util.List;

public interface IBillService {
    List<Bill> findAll(String name , String idBuilding);

    void save(BillDTO billDTO);

    Bill findById(String id);
}
