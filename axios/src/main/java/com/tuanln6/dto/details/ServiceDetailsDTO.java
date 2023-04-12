package com.tuanln6.dto.details;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class ServiceDetailsDTO {
    @NotBlank
    String serviceId;
    @NotBlank
    String customerId;

    @NotNull
    @Future
    Date dateBegin;

    @NotNull
    String timeBegin;

    @Min(1)
    @NotNull
    Long amount;

    public ServiceDetailsDTO() {
    }

    public ServiceDetailsDTO(String serviceId, String customerId, Date dateBegin, String timeBegin, Long amount) {
        this.serviceId = serviceId;
        this.customerId = customerId;
        this.dateBegin = dateBegin;
        this.timeBegin = timeBegin;
        this.amount = amount;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
