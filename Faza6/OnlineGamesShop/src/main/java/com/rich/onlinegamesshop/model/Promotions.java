package com.rich.onlinegamesshop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_promotion")
public class Promotions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_promotion;

    private String title;

    private LocalDate startDate;
    private LocalDate endDate;

    private BigDecimal discountPercentage;

    @OneToMany (mappedBy = "id_promotion")
    @JsonIgnoreProperties("id_promotion")
    private List<OrdersAreRelatedToPromotions> orders;

}
