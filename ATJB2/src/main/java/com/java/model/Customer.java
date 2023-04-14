package com.java.model;

import com.java.dto.CustomerDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator",
            parameters = @Parameter(name = "prefix", value = "KH"),
            strategy = "com.java.utils.AutoGeneration")
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
        this.email = customerDTO.getEmail();
        this.phone = customerDTO.getPhone();
        this.status = "on";
    }


    public Customer(String id, String name, String address, String phone, String email, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email="
                + email + "]";
    }

}
