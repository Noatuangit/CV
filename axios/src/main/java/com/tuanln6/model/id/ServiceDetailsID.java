package com.tuanln6.model.id;


import com.tuanln6.dto.details.ServiceDetailsDTO;
import com.tuanln6.dto.view.ServiceViewDetailsDTO;
import com.tuanln6.model.AddOnService;
import com.tuanln6.model.Customer;
import com.tuanln6.utils.DateConverter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Embeddable
public class ServiceDetailsID implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "id")
    AddOnService service;

    Date date_use;
    Time time_begin;

    public ServiceDetailsID() {
    }

    public ServiceDetailsID(Customer customer, AddOnService service, Date date_use, Time time_begin) {
        this.customer = customer;
        this.service = service;
        this.date_use = date_use;
        this.time_begin = time_begin;
    }

    public ServiceDetailsID(ServiceDetailsDTO serviceDetailsDTO) {
        this.customer = new Customer(serviceDetailsDTO.getCustomerId());
        this.service = new AddOnService(serviceDetailsDTO.getServiceId());
        this.date_use = (serviceDetailsDTO.getDateBegin());
        this.time_begin = Time.valueOf(serviceDetailsDTO.getTimeBegin().concat(":00"));
    }

    public ServiceDetailsID(ServiceViewDetailsDTO serviceViewDetailsDTO) {
        this.service = new AddOnService(serviceViewDetailsDTO.getServiceId());
        this.customer = new Customer(serviceViewDetailsDTO.getCustomerId());
        this.date_use = DateConverter.converterStringToDate(serviceViewDetailsDTO.getDate_use());
        this.time_begin = serviceViewDetailsDTO.getTime_begin();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AddOnService getService() {
        return service;
    }

    public void setService(AddOnService service) {
        this.service = service;
    }

    public Date getDate_use() {
        return date_use;
    }

    public void setDate_use(Date date_use) {
        this.date_use = date_use;
    }

    public Time getTime_begin() {
        return time_begin;
    }

    public void setTime_begin(Time time_begin) {
        this.time_begin = time_begin;
    }
}
