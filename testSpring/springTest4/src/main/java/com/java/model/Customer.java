package com.java.model;

import com.java.dto.FormDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
 @Table(name = "customer")
public class Customer {
    @Id
    String idCard;
    String name;


    Date birthday;
    String gender;
    String phone;
    String status;
    String result;
    Date dayTest;

    public Customer() {
    }

    public Customer(FormDTO dto) {
        this.idCard = dto.getIdCard();
        this.name = dto.getName();
        this.birthday = (dto.getBirthday());
        this.gender = dto.getGender();
        this.phone = dto.getPhone();
        this.status = dto.getStatus();
        this.result = dto.getResult();
        this.dayTest = dto.getDayTest();
    }

    public Customer(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
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
}
