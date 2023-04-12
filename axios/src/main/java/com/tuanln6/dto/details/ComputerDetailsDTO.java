package com.tuanln6.dto.details;

import com.tuanln6.utils.ComputerIdExists;
import com.tuanln6.utils.CustomerIdExists;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class ComputerDetailsDTO {
    @NotBlank
    @ComputerIdExists
    String computerId;

    @NotBlank
    @CustomerIdExists
    String customerId;

    @NotNull
    @Future
    Date dateBegin;

    @NotBlank
    String timeBegin;

    @Min(1)
    @NotNull
    Integer timeUse;

    public ComputerDetailsDTO() {
    }

    public ComputerDetailsDTO(String computerId, String customerId, Date dateBegin, String timeBegin, Integer timeUse) {
        this.computerId = computerId;
        this.customerId = customerId;
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

    public Integer getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(Integer timeUse) {
        this.timeUse = timeUse;
    }
}
