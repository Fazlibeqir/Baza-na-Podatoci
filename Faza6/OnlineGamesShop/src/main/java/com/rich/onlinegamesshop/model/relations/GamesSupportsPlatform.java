package com.rich.onlinegamesshop.model.relations;

import com.rich.onlinegamesshop.model.Games;
import com.rich.onlinegamesshop.model.Platform;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class GamesSupportsPlatform {
    @Id
    @ManyToOne
    @JoinColumn(name = "gameId",nullable = false)
    private Games game;

    @Id
    @ManyToOne
    @JoinColumn(name = "platformId",nullable = false)
    private Platform platform;

    public GamesSupportsPlatform(Games game, Platform platform) {
        this.game = game;
        this.platform = platform;
    }
}
