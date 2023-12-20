package com.rich.onlinegamesshop.model.relations.combineIds;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrdersContainsGamesId implements Serializable {
    private Integer id_order;
    private Integer id_game;

    public OrdersContainsGamesId(Integer id_order, Integer id_game) {
        this.id_order = id_order;
        this.id_game = id_game;
    }
}
