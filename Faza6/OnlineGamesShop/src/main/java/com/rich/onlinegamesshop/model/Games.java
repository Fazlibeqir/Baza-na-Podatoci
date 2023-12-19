package com.rich.onlinegamesshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private BigDecimal price;

    private String Developer;

    @Column(nullable = false)
    private Integer stock;

    LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name="publisherId",nullable = false)
    Publisher publisher;

    public Games(String title, String genre, BigDecimal price, String developer, Integer stock, LocalDate releaseDate, Publisher publisher) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        Developer = developer;
        this.stock = stock;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
    }
}
