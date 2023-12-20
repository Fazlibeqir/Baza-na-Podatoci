package com.rich.onlinegamesshop.model;

import com.rich.onlinegamesshop.model.relations.OrdersAreRelatedToPromotions;
import com.rich.onlinegamesshop.model.relations.OrdersContainsGames;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_order;

    private String status;

    private LocalDate orderDate;

    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "id_costumer",nullable = false)
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name="id_payment",nullable = false)
    private Payment payment;

    @OneToMany(mappedBy = "id_order")
    private List<OrdersAreRelatedToPromotions> promotions;

    @OneToMany(mappedBy = "id_order")
    private List<OrdersContainsGames> games;

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
