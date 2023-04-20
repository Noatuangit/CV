package com.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeCustomer")
public class TypeCustomer {
    @Id
    String id;
    String name;
    Long discount;

    public TypeCustomer() {
    }

    public TypeCustomer(String id, String name, Long discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public TypeCustomer(String typeId) {
        this.id = typeId;
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

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }
}
