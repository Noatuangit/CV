package com.java.dto;

import com.java.model.Ticket;

import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;

public class FormDTO {
    String id;

    @Pattern(regexp = "^[0-9]{9}$", message = " sai dinh dang")
    String idCard;
    String name;
    Date birthday;
    String gender;
    @Pattern(regexp = "^0[0-9]{9,10}$", message = "phone sai dinh dang")
    String phone;
    String status;
    String result;
    Date dayTest;
    Date dayOrder;
    @Pattern(regexp = "^[0-9]{2}[A-Z]-[0-9]{3}.[0-9]{2}$", message = "bien so xe sai dinh dang")
    String carId;
    String placeIn;
    String placeOut;
    Date dayBegin;

    public FormDTO() {
        this.dayOrder = Date.valueOf(LocalDate.now());
    }

    public FormDTO(Ticket ticket) {
        this.idCard = ticket.getCustomer().getIdCard();
        this.name = ticket.getCustomer().getName();
        this.birthday = ticket.getCustomer().getBirthday();
        this.phone = ticket.getCustomer().getPhone();
        this.gender = ticket.getCustomer().getGender();
        this.status = ticket.getCustomer().getStatus();
        this.result = ticket.getCustomer().getResult();
        this.dayTest = ticket.getCustomer().getDayTest();
        this.dayOrder = ticket.getDayOrder();
        this.carId = ticket.getCarId();
        this.placeIn = ticket.getPlaceIn();
        this.placeOut = ticket.getPlaceOut();
        this.dayBegin = ticket.getDayBegin();
    }

    public String getIdCard() {
        return idCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDayTest() {
        return dayTest;
    }

    public void setDayTest(Date dayTest) {
        this.dayTest = dayTest;
    }

    public Date getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(Date dayOrder) {
        this.dayOrder = dayOrder;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPlaceIn() {
        return placeIn;
    }

    public void setPlaceIn(String placeIn) {
        this.placeIn = placeIn;
    }

    public String getPlaceOut() {
        return placeOut;
    }

    public void setPlaceOut(String placeOut) {
        this.placeOut = placeOut;
    }

    public Date getDayBegin() {
        return dayBegin;
    }

    public void setDayBegin(Date dayBegin) {
        this.dayBegin = dayBegin;
    }
}
