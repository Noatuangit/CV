package com.java.model;

import com.java.dto.FormDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator",
            parameters = @Parameter(name = "prefix", value = "DV"),
            strategy = "com.java.utils.AutoGeneration")
    String id;
    Date dayOrder;
    String carId;
    String placeIn;
    String placeOut;
    Date dayBegin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", nullable = false, referencedColumnName = "idCard")
    Customer customer;

    public Ticket(FormDTO dto) {
        this.carId = dto.getCarId();
        this.customer = new Customer(dto.getIdCard());
        this.dayOrder = dto.getDayOrder();
        this.dayBegin = dto.getDayBegin();
        this.placeIn = dto.getPlaceIn();
        this.placeOut = dto.getPlaceOut();
    }

    public Ticket() {
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", dayOrder=" + dayOrder +
                ", carId='" + carId + '\'' +
                ", placeIn='" + placeIn + '\'' +
                ", placeOut='" + placeOut + '\'' +
                ", dayBegin=" + dayBegin +
                ", customer=" + customer +
                '}';
    }
}
