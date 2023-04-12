package com.tuanln6.dto.view;

import com.tuanln6.model.ServiceDetails;
import com.tuanln6.utils.DateConverter;

import java.sql.Time;

public class ServiceViewDetailsDTO {
    String customerId;
    String customerName;
    String  serviceId;
    String date_use;
    Time time_begin;
    Long amount;

    public ServiceViewDetailsDTO() {
    }

    public ServiceViewDetailsDTO(ServiceDetails serviceDetails) {
        this.customerId = serviceDetails.getServiceDetailsID().getCustomer().getId();
        this.customerName = serviceDetails.getServiceDetailsID().getCustomer().getName();
        this.serviceId = serviceDetails.getServiceDetailsID().getService().getId();
        this.date_use = DateConverter.converterDateToString(serviceDetails.getServiceDetailsID().getDate_use());
        this.time_begin = serviceDetails.getServiceDetailsID().getTime_begin();
        this.amount = serviceDetails.getAmount();
    }


    public ServiceViewDetailsDTO(String customerId, String customerName, String serviceId, String date_use, Time time_begin, Long amount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.serviceId = serviceId;
        this.date_use = date_use;
        this.time_begin = time_begin;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDate_use() {
        return date_use;
    }

    public void setDate_use(String date_use) {
        this.date_use = date_use;
    }

    public Time getTime_begin() {
        return time_begin;
    }

    public void setTime_begin(Time time_begin) {
        this.time_begin = time_begin;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }


}
