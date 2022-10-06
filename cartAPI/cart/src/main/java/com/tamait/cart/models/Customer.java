package com.tamait.cart.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String email;

    public Customer(Integer customerId) {
        this.id = customerId;
    }
}
