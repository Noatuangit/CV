package com.tamait.cart.dto;

import com.tamait.cart.models.Customer;
import com.tamait.cart.models.Order;
import com.tamait.cart.models.Product;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordersLog")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    Timestamp dayBook;

    public OrderDTO(Integer orderId,
                    Integer productId,
                    Integer customerId) {
        this.product = new Product(productId);
        this.order = new Order(orderId);
        this.customer = new Customer(customerId);
        this.dayBook = Timestamp.valueOf(LocalDateTime.now());
    }
}
