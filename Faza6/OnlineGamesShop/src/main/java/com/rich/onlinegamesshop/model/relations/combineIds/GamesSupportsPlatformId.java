package com.rich.onlinegamesshop.model.relations.combineIds;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GamesSupportsPlatformId implements Serializable {
    private Integer id_game;
    private Integer id_platform;

    public GamesSupportsPlatformId(Integer id_game, Integer id_platform) {
        this.id_game = id_game;
        this.id_platform = id_platform;
    }
}
