package com.java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.dto.OrderDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator",
            parameters = @Parameter(name = "prefix", value = "DH"),
            strategy = "com.java.utils.AutoGeneration")
    String id;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false, referencedColumnName = "id")
    Customer customer;

    @Column(name = "dateOrder")
    Date dateOrder;

    @Column(name = "statusCheckOut")
    String statusCheckOut;

    @Column(name = "dateEnd")
    Date dateEnd;

    @Column(name = "statusOrder")
    String statusOrder;

    @Column(name = "datePay")
    Date datePay;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Details> list;

    public Order() {
    }

    public Order(String id, Customer customer, Date dateOrder, String statusCheckOut, Date dateEnd, String statusOrder, Date datePay) {
        this.id = id;
        this.customer = customer;
        this.dateOrder = dateOrder;
        this.statusCheckOut = statusCheckOut;
        this.dateEnd = dateEnd;
        this.statusOrder = statusOrder;
        this.datePay = datePay;
    }

    public Order(OrderDTO dto) {
        this.id = dto.getId();
        this.customer = new Customer(dto.getCustomer());
        this.dateOrder = Date.valueOf(dto.getDateOrder());
        this.dateEnd = Date.valueOf(dto.getDateEnd());
        this.statusCheckOut = dto.getStatusCheckOut();
        this.statusOrder = dto.getStatusOrder() == null ? "chua giao hang" : dto.getStatusOrder();
        if (dto.getDatePay() != null) {
            this.datePay = Date.valueOf(dto.getDatePay());
        }

    }

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatusCheckOut() {
        return statusCheckOut;
    }

    public List<Details> getList() {
        return list;
    }

    public void setList(List<Details> list) {
        this.list = list;
    }

    public void setStatusCheckOut(String statusCheckOut) {
        this.statusCheckOut = statusCheckOut;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", dateOrder=" + dateOrder +
                ", statusCheckOut='" + statusCheckOut + '\'' +
                ", dateEnd=" + dateEnd +
                ", statusOrder='" + statusOrder + '\'' +
                ", datePay=" + datePay +
                '}';
    }
}
