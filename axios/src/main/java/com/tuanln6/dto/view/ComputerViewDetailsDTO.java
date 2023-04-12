package com.tuanln6.dto.view;

import com.tuanln6.model.ComputerDetails;
import com.tuanln6.utils.DateConverter;

import java.sql.Time;

public class ComputerViewDetailsDTO {
    String computerId;
    String customerId;
    String customerName;
    String dateBegin;
    Time timeBegin;
    Integer timeUse;


    public ComputerViewDetailsDTO() {
    }

    public ComputerViewDetailsDTO(ComputerDetails computerDetails) {
        this.computerId = computerDetails.getComputerDetailsID().getComputer().getId();
        this.customerId = computerDetails.getComputerDetailsID().getCustomer().getId();
        this.customerName = computerDetails.getComputerDetailsID().getCustomer().getName();
        this.dateBegin = DateConverter.converterDateToString(computerDetails.getComputerDetailsID().getDate_begin());
        this.timeBegin = computerDetails.getComputerDetailsID().getTime_begin();
        this.timeUse = computerDetails.getTime_use();
    }

    public ComputerViewDetailsDTO(String computerId, String customerId, String customerName, String dateBegin, Time timeBegin, Integer timeUse) {
        this.computerId = computerId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.dateBegin = dateBegin;
        this.timeBegin = timeBegin;
        this.timeUse = timeUse;
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Time getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Time timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Integer getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(Integer timeUse) {
        this.timeUse = timeUse;
    }
}

