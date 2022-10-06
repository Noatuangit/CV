package com.tamait.cart.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "oders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    Customer customer;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = ShopCart.class)
    @JoinColumn(name="oders_id")
    List<ShopCart> shopCartList;

    public Order(Integer orderId) {
        this.id = orderId;
    }

}
