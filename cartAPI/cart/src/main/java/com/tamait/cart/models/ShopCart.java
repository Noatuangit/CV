package com.tamait.cart.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "shopcart")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ShopCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    Integer quantity;

    Integer money;

}
