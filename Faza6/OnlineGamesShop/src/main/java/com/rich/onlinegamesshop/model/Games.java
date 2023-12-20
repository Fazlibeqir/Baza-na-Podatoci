package com.rich.onlinegamesshop.model;

import com.rich.onlinegamesshop.model.relations.GamesSupportsPlatform;
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
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_game;

    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    private String Developer;

    @Column(nullable = false)
    private Integer stock;

    LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name="id_publisher",nullable = false)
    Publisher publisher;

    @OneToMany(mappedBy = "id_game")
    private List<GamesSupportsPlatform> supportedPlatforms;

    @OneToMany(mappedBy = "id_game")
    private List<OrdersContainsGames> orders;

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
