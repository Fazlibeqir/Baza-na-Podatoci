package com.rich.onlinegamesshop.model.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklySalesReport {
    private String username;
    private  BigDecimal weekNumber;
    private Long totalOrders;
    private BigDecimal totalSales;
}
