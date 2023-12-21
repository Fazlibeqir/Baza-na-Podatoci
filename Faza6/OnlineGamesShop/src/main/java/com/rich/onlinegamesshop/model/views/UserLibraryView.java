package com.rich.onlinegamesshop.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Immutable
@Table(name = "userlibraryview")
@NoArgsConstructor
@AllArgsConstructor
public class UserLibraryView {
    @Id
    private String title;
    private String genre;
    private BigDecimal price;
    private String developer;
    private int stock;
    private LocalDate releaseDate;
    private BigDecimal discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal amount;
    private String paymentMethod;
    private LocalDate date;
}