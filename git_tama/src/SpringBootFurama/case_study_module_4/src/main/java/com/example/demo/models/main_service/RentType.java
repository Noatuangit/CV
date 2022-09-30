package com.example.demo.models.main_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rent_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Double rent_type_cost;
}
