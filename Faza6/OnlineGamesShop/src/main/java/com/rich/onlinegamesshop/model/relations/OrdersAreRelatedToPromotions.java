package com.rich.onlinegamesshop.model.relations;

import com.rich.onlinegamesshop.model.Orders;
import com.rich.onlinegamesshop.model.Promotions;
import com.rich.onlinegamesshop.model.relations.combineIds.OrdersAreRelatedToPromotionsId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@IdClass(OrdersAreRelatedToPromotionsId.class)
public class OrdersAreRelatedToPromotions {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_order",nullable = false)
    private Orders id_order;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_promotion",nullable = false)
    private Promotions id_promotion;

    public OrdersAreRelatedToPromotions(Orders id_order, Promotions id_promotion) {
        this.id_order = id_order;
        this.id_promotion = id_promotion;
    }
}
