package com.example.demo.models.customer;

import com.example.demo.dto.CustomerDTO;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private static final long serialVersionUID = -291232132133233123L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "type_customer_id", nullable = false, referencedColumnName = "id")
    CustomerType customerType;

//    Integer type_customer_id;

    @Column(name = "name")
    String name;

    @Column(name = "birthday")
    Date birthday;

    @Column(name = "id_card")
    String id_card;

    @Column(name = "gender")
    Boolean gender;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "address")
    String address;

    @Column(name = "status")
    String status;

    public Customer(CustomerDTO customerDTO) {
        CustomerType customerType = new CustomerType();
        customerType.setId(customerDTO.getCustomerType());
        this.id = null;
        this.name = customerDTO.getName();
        this.birthday = Date.valueOf(customerDTO.getBirthday());
        this.customerType = customerType;
        this.id_card = customerDTO.getId_card();
        this.gender = customerDTO.getGender() == 1;
        this.phone = customerDTO.getPhone();
        this.email = customerDTO.getEmail();
        this.address = customerDTO.getAddress();
        this.status = "on";
    }
}
