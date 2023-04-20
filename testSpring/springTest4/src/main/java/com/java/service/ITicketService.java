package com.java.service;

import com.java.dto.FormDTO;
 import com.java.model.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAllByCondition(String status, String result);


    void save(FormDTO dto);

    Ticket findById(String id);
}
