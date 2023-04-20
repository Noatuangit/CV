package com.java.model;

import com.java.dto.OrderDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator",
            parameters = @Parameter(name = "prefix", value = "CD"),
            strategy = "com.java.utils.AutoGeneration")
    String id;

    String name;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false, referencedColumnName = "id")
    TypeCustomer customer;

    String phone;
    @Column(name = "dateOrder")
    Date dateOrder;
    Long persons;

    @Column(name = "childs")
    Long children;

    Time timeIn;

    Double total;

    public Order() {
    }

    public Order(String id, String name, TypeCustomer customer, String phone, Date dateOrder, Long persons, Long children, Time timeIn, Double total) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.phone = phone;
        this.dateOrder = dateOrder;
        this.persons = persons;
        this.children = children;
        this.timeIn = timeIn;
        this.total = total;
    }

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.name = orderDTO.getName();
        this.customer = new TypeCustomer(orderDTO.getTypeId());
        this.persons = orderDTO.getPersons();
        this.children = orderDTO.getChildren();
        this.timeIn = Time.valueOf(orderDTO.getTimeIn());
        this.dateOrder = Date.valueOf(orderDTO.getDateOrder());
        this.phone = orderDTO.getPhone();
        this.total = orderDTO.getTotal();
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

    public TypeCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TypeCustomer customer) {
        this.customer = customer;
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

    public Long getPersons() {
        return persons;
    }

    public void setPersons(Long persons) {
        this.persons = persons;
    }

    public Long getChildren() {
        return children;
    }

    public void setChildren(Long childs) {
        this.children = childs;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
