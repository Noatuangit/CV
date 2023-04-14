package com.java.dto;

 import com.java.utils.CustomerIdExists;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;


public class ComDetailsDTO {
     @NotBlank
    String computer_id;

    @CustomerIdExists
    @NotBlank
    String customer_id;

    @NotNull
    @Future
    Date date_begin;

    @NotBlank
    String time_begin;

    @Min(1)
    @NotNull
    Integer timeUse;

    public ComDetailsDTO() {
    }

    public ComDetailsDTO(String computer_id, String customer_id, Date date_begin, String time_begin, Integer timeUse) {
        this.computer_id = computer_id;
        this.customer_id = customer_id;
        this.date_begin = date_begin;
        this.time_begin = time_begin;
        this.timeUse = timeUse;
    }

    public String getComputer_id() {
        return computer_id;
    }

    public void setComputer_id(String computer_id) {
        this.computer_id = computer_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    public String getTime_begin() {
        return time_begin;
    }

    public void setTime_begin(String time_begin) {
        this.time_begin = time_begin;
    }

    public Integer getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(Integer timeUse) {
        this.timeUse = timeUse;
    }

    @Override
    public String toString() {
        return "ComDetailsDTO{" +
                "computer_id='" + computer_id + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", date_begin=" + date_begin +
                ", time_begin='" + time_begin + '\'' +
                ", timeUse=" + timeUse +
                '}';
    }
}
