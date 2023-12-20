package com.rich.onlinegamesshop.model.relations;

import com.rich.onlinegamesshop.model.Games;
import com.rich.onlinegamesshop.model.Platform;
import com.rich.onlinegamesshop.model.relations.combineIds.GamesSupportsPlatformId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@IdClass(GamesSupportsPlatformId.class)
public class GamesSupportsPlatform {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_game",nullable = false)
    private Games id_game;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_platform",nullable = false)
    private Platform id_platform;

    public GamesSupportsPlatform(Games id_game, Platform id_platform) {
        this.id_game = id_game;
        this.id_platform = id_platform;
    }
}
