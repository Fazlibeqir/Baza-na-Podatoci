package com.rich.onlinegamesshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Column(nullable = false)
    private String paymentMethod;

    private LocalDate date;

    private BigDecimal amount;

    public Payment(String paymentMethod, LocalDate date, BigDecimal amount) {
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.amount = amount;
    }
}
