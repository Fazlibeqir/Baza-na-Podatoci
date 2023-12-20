package com.rich.onlinegamesshop.model.relations;

import com.rich.onlinegamesshop.model.Games;
import com.rich.onlinegamesshop.model.Orders;
import com.rich.onlinegamesshop.model.relations.combineIds.OrdersContainsGamesId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@IdClass(OrdersContainsGamesId.class)
public class OrdersContainsGames {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_order",nullable = false)
    private Orders id_order;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_game",nullable = false)
    private Games id_game;

    public OrdersContainsGames(Orders id_order, Games id_game) {
        this.id_order = id_order;
        this.id_game = id_game;
    }
}
