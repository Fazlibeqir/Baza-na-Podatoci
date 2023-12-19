package com.rich.onlinegamesshop.model.relations;

import com.rich.onlinegamesshop.model.Orders;
import com.rich.onlinegamesshop.model.Promotions;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class OrdersAreRelatedToPromotions {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "promotionId",nullable = false)
    private Promotions promotion;

    public OrdersAreRelatedToPromotions(Orders order, Promotions promotion) {
        this.order = order;
        this.promotion = promotion;
    }
}
