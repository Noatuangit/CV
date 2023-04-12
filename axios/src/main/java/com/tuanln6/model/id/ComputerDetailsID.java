package com.tuanln6.model.id;

import com.tuanln6.dto.details.ComputerDetailsDTO;
import com.tuanln6.dto.view.ComputerViewDetailsDTO;
import com.tuanln6.model.Computer;
import com.tuanln6.model.Customer;
import com.tuanln6.utils.DateConverter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Embeddable
public class ComputerDetailsID implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "computer_id", nullable = false, referencedColumnName = "id")
    Computer computer;

    Date date_begin;

    Time time_begin;

    public ComputerDetailsID() {
    }

    public ComputerDetailsID(Customer customer, Computer computer, Date date_begin, Time time_begin) {
        this.customer = customer;
        this.computer = computer;
        this.date_begin = date_begin;
        this.time_begin = time_begin;
    }

    public ComputerDetailsID(ComputerDetailsDTO computerDetailsDTO) {
        this.computer = new Computer(computerDetailsDTO.getComputerId());
        this.customer = new Customer(computerDetailsDTO.getCustomerId());
        this.date_begin = computerDetailsDTO.getDateBegin();
        this.time_begin = Time.valueOf(computerDetailsDTO.getTimeBegin().concat(":00"));
    }

    public ComputerDetailsID(ComputerViewDetailsDTO computerViewDetailsDTO) {
        this.computer = new Computer(computerViewDetailsDTO.getComputerId());
        this.customer = new Customer(computerViewDetailsDTO.getCustomerId());
        this.date_begin = DateConverter.converterStringToDate(computerViewDetailsDTO.getDateBegin());
        this.time_begin = (computerViewDetailsDTO.getTimeBegin());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    public Time getTime_begin() {
        return time_begin;
    }

    public void setTime_begin(Time time_begin) {
        this.time_begin = time_begin;
    }
}
