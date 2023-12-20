package com.rich.onlinegamesshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_review;

    private Integer rating;

    private String Comment;
    @ManyToOne
    @JoinColumn(name = "id_costumer",nullable = false)
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name = "id_game",nullable = false)
    private Games games;

    public Review(Integer rating, String comment,
                  Costumer costumer, Games games) {
        this.rating = rating;
        Comment = comment;
        this.costumer = costumer;
        this.games = games;
    }
}
