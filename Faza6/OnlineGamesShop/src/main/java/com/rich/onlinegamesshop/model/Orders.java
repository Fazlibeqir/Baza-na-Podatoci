package com.rich.onlinegamesshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String status;

    private LocalDate orderDate;

    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "consumerId",nullable = false)
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name="paymentId",nullable = false)
    private Payment payment;

    public Orders(String status, LocalDate orderDate,
                  BigDecimal totalAmount, Costumer costumer,
                  Payment payment) {
        this.status = status;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.costumer = costumer;
        this.payment = payment;
    }
}
