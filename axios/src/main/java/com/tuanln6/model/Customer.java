package com.tuanln6.model;

import com.tuanln6.dto.customer.CustomerDTO;
import com.tuanln6.dto.customer.CustomerEditDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator", parameters = @Parameter(name = "prefix", value = "KH"), strategy = "com.tuanln6.utils.AutoGeneration")
    String id;

    String name;

    String address;

    String phone;

    String email;

    String status;

    public Customer() {
    }

    public Customer(String id) {
        this.id = id;
    }

    public Customer(CustomerDTO customerDTO) {
        this.name = customerDTO.getName();
        this.address = customerDTO.getAddress();
        this.phone = customerDTO.getPhone();
        this.status = "on";
        this.email = customerDTO.getEmail();
    }


    public Customer(CustomerEditDTO dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.phone = dto.getPhone();
        this.status = "on";
        this.email = dto.getEmail();
        this.id = dto.getId();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
