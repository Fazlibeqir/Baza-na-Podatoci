package com.rich.onlinegamesshop.model.relations.combineIds;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrdersAreRelatedToPromotionsId implements Serializable {
    private Integer id_order;
    private Integer id_promotion;

    public OrdersAreRelatedToPromotionsId(Integer id_order, Integer id_promotion) {
        this.id_order = id_order;
        this.id_promotion = id_promotion;
    }
}
