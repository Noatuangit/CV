package com.tamait.cart.models;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "orders")
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShopCart.class)
            @JoinColumn(name = "orders_id")
    Collection<ShopCart> shopCartList;

    public Order(Integer orderId) {
        this.id = orderId;
    }

}
