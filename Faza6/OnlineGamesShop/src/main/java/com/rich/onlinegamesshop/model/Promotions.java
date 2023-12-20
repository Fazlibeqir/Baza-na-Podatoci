package com.rich.onlinegamesshop.model;

import com.rich.onlinegamesshop.model.relations.OrdersAreRelatedToPromotions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Promotions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_promotion;

    private String title;

    private LocalDate startDate;
    private LocalDate endDate;

    private BigDecimal discountPercentage;

    @OneToMany (mappedBy = "id_promotion")
    private List<OrdersAreRelatedToPromotions> orders;

}
