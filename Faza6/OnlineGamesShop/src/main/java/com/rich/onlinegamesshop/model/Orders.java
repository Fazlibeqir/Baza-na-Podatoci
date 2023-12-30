package com.rich.onlinegamesshop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_order")
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
    @JsonIgnore
    private List<OrdersAreRelatedToPromotions> promotions;

    @OneToMany(mappedBy = "id_order")
    @JsonIgnore
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
