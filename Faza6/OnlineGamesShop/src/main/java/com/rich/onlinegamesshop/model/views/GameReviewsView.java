package com.rich.onlinegamesshop.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "gamereviewsview")
@NoArgsConstructor
@AllArgsConstructor
public class GameReviewsView {
    @Id
    private Integer id_review;
    private Integer rating;
    private String comment;
    private String username;
    private Integer id_game;
    private String game_title;
    private String game_genre;
}
