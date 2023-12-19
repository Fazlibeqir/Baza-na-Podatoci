package com.rich.onlinegamesshop.model.relations;

import com.rich.onlinegamesshop.model.Games;
import com.rich.onlinegamesshop.model.Orders;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class OrdersContainsGames {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "gameId",nullable = false)
    private Games game;

    public OrdersContainsGames(Orders order, Games game) {
        this.order = order;
        this.game = game;
    }
}
