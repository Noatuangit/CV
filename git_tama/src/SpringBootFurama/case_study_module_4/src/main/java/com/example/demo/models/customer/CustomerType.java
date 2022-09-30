package com.example.demo.models.customer;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "type_customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerType {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;
}
