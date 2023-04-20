package com.java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.java.dto.OrderDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator",
            parameters = @Parameter(name = "prefix", value = "CTDH"),
            strategy = "com.java.utils.AutoGeneration")
    String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", nullable = false, referencedColumnName = "id")
    Order order;

    String name;

    Long total;

    String note;

    public Details() {
    }

    public Details(String id) {

    }


    public Details(Order order, OrderDTO dto) {
        this.order = new Order(order.getId());
        this.name = dto.getName();
        this.total = dto.getMoney();
        this.note = dto.getNote();
        this.id = dto.getIdDetails();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id='" + id + '\'' +
                ", order=" + order +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", note='" + note + '\'' +
                '}';
    }
}
