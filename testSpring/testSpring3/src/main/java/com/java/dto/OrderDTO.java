package com.java.dto;

import com.java.model.Order;
import com.java.utils.ValidCustomerExists;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class OrderDTO implements Validator {
    private String id;
    @ValidCustomerExists
    private String customer;
    private String dateOrder;
    private String statusCheckOut;
    private String dateEnd;
    private String statusOrder;
    private String datePay;
    private String name;
    private Long money;
    private String note;
    private String idDetails;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.customer = order.getCustomer().getId();
        this.dateOrder = order.getDateOrder().toString();
        this.statusCheckOut = order.getStatusCheckOut();
        this.dateEnd = order.getDateEnd().toString();
        this.statusOrder = order.getStatusOrder();
        this.datePay = order.getDatePay() != null ? order.getDatePay().toString() : "";
        if (order.getList().size() > 0) {
            this.idDetails = order.getList().get(0).getId();
            this.name = order.getList().get(0).getName();
            this.money = order.getList().get(0).getTotal();
            this.note = order.getList().get(0).getNote();
        }
    }

    public String getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(String idDetails) {
        this.idDetails = idDetails;
    }

    public String getDatePay() {
        return datePay;
    }

    public void setDatePay(String datePay) {
        this.datePay = datePay;
    }

    public OrderDTO() {
        this.dateOrder = LocalDate.now().toString();
    }

    public String getId() {
        return id;
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

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatusCheckOut() {
        return statusCheckOut;
    }

    public void setStatusCheckOut(String statusCheckOut) {
        this.statusCheckOut = statusCheckOut;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderDTO orderDTO = (OrderDTO) target;
        if (orderDTO.getName().contains("Ao")) {
            if (orderDTO.getMoney() < 100000) {
                errors.rejectValue("money", "money", "Số tiền không hợp lệ.");
                return;
            }
        }
        if (orderDTO.getName().contains("Quan") || orderDTO.getName().contains("Chan vay")) {
            if (orderDTO.getMoney() < 150000) {
                errors.rejectValue("money", "money", "Số tiền không hợp lệ.");
            }
        }
    }
}
