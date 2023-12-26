package com.rich.onlinegamesshop.model.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YearlyGameStatisticsReport {
    private String title;
    private BigDecimal yearNumber;
    private long totalPlatforms;
    private BigDecimal averageRating;
    private BigDecimal totalSales;
}
