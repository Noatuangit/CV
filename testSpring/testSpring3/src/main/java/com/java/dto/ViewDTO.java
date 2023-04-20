package com.java.dto;

import com.java.model.Order;

import java.sql.Date;
import java.util.stream.Collectors;

public class ViewDTO {
    String id;
    String customer;
    String name;
    String gender;
    String phone;
    Date dateOrder;
    String statusOrder;
    Date dateEnd;
    String statusCheckOut;
    Date datePay;
    String list;

    public ViewDTO(Order order) {
        this.id = order.getId();
        this.customer = order.getCustomer().getId();
        this.name = order.getCustomer().getName();
        this.gender = order.getCustomer().getGender();
        this.phone = order.getCustomer().getPhone();
        this.dateOrder = order.getDateOrder();
        this.statusOrder = order.getStatusOrder();
        this.dateEnd = order.getDateEnd();
        this.statusCheckOut = order.getStatusCheckOut();
        this.datePay = order.getDatePay();
        this.list = order
                .getList()
                .stream()
                .map(x -> String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", x.getId(), x.getName(), x.getTotal(), x.getNote()))
                .collect(Collectors.joining());
    }

    public String getId() {
        return id;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatusCheckOut() {
        return statusCheckOut;
    }

    public void setStatusCheckOut(String statusCheckOut) {
        this.statusCheckOut = statusCheckOut;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
