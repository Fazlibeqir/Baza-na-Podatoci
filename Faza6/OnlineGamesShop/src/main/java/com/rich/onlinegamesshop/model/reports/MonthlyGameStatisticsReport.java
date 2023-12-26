package com.rich.onlinegamesshop.model.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyGameStatisticsReport {
    private String genre;
    private String publisher;
    private BigDecimal monthNumber;
    private long totalReviews;
    private BigDecimal totalRevenue;

}
