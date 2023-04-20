package com.java.dto;

import com.java.model.Order;
import com.java.utils.ValidTypeExists;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrderDTO {
    String id;
    @NotEmpty
    String name;

    @NotEmpty
    @ValidTypeExists
    String typeId;

    @Pattern(regexp = "^0365[0-9]{7}$", message = " not correct type 0365xxxxxxx.")
    String phone;

    String dateOrder;

    @Min(1)
    @NotNull
    Long persons;

    @Min(1)
    @NotNull
    Long children;

    String timeIn;

    Double total;

    public OrderDTO() {
        this.dateOrder = Date.valueOf(LocalDate.now()).toString();
        this.timeIn = Time.valueOf(LocalTime.now()).toString();
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.typeId = order.getCustomer().getId();
        this.timeIn = order.getTimeIn().toString();
        this.dateOrder = order.getDateOrder().toString();
        this.name = order.getName();
        this.children = order.getChildren();
        this.persons = order.getPersons();
        this.phone = order.getPhone();
        this.total = order.getTotal();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Long getPersons() {
        return persons;
    }

    public void setPersons(Long persons) {
        this.persons = persons;
    }

    public Long getChildren() {
        return children;
    }

    public void setChildren(Long children) {
        this.children = children;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }
}
