package com.java.model;

import com.java.dto.ServiceBookingDTO;
import com.java.model.compositeID.ServiceDetailsID;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="service_detail")
public class ServiceDetails {

    @EmbeddedId
    ServiceDetailsID serviceDetailsID;

    Long amount;

    public ServiceDetails() {
    }

    public ServiceDetails(ServiceDetailsID serviceDetailsID, Long amount) {
        this.serviceDetailsID = serviceDetailsID;
        this.amount = amount;
    }

    public ServiceDetails(ServiceBookingDTO serviceBookingDTO) {
        this.amount = Long.parseLong(serviceBookingDTO.getAmount());
        this.serviceDetailsID = new ServiceDetailsID(serviceBookingDTO);
    }

    public ServiceDetailsID getServiceDetailsID() {
        return serviceDetailsID;
    }

    public void setServiceDetailsID(ServiceDetailsID serviceDetailsID) {
        this.serviceDetailsID = serviceDetailsID;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
