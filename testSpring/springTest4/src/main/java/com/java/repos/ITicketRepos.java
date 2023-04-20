package com.java.repos;

import com.java.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketRepos extends JpaRepository<Ticket, String> {
    List<Ticket> findAllByCustomerStatusContainingAndCustomerResultContaining(String customer_status, String customer_result);
}
