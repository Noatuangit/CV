package com.tuanln6.model;

 import com.tuanln6.dto.details.ServiceDetailsDTO;
 import com.tuanln6.dto.view.ServiceViewDetailsDTO;
 import com.tuanln6.model.id.ServiceDetailsID;

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

    public ServiceDetails(ServiceDetailsDTO serviceDetailsDTO) {
        this.amount = serviceDetailsDTO.getAmount();
        this.serviceDetailsID = new ServiceDetailsID(serviceDetailsDTO);
    }

    public ServiceDetails(ServiceDetailsID serviceDetailsID, Long amount) {
        this.serviceDetailsID = serviceDetailsID;
        this.amount = amount;
    }

    public ServiceDetails(ServiceViewDetailsDTO serviceViewDetailsDTO) {
        this.amount = serviceViewDetailsDTO.getAmount();
        this.serviceDetailsID = new ServiceDetailsID(serviceViewDetailsDTO);
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
