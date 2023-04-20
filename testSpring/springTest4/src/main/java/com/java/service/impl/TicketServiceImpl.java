package com.java.service.impl;

import com.java.dto.FormDTO;
import com.java.model.Customer;
import com.java.model.Ticket;
import com.java.repos.ITicketRepos;
import com.java.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    ITicketRepos repos;

    @Override
    public List<Ticket> findAllByCondition(String status, String result) {
        return repos.findAllByCustomerStatusContainingAndCustomerResultContaining(status, result);
    }

    @Override
    public void save(FormDTO dto) {
        repos.save(new Ticket(dto));
    }

    @Override
    public Ticket findById(String id) {
        return repos.findById(id).orElse(null);
    }
}
