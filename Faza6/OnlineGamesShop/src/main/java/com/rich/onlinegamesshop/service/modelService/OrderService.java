package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.reports.MonthlyGameStatisticsReport;
import com.rich.onlinegamesshop.model.reports.WeeklySalesReport;
import com.rich.onlinegamesshop.model.reports.YearlyGameStatisticsReport;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    void insertOrder(String status, LocalDate orderDate, BigDecimal totalAmount, Integer idCostumer, Integer idPayment, Integer[] gameIds, Integer[] promotionIds);
    List<WeeklySalesReport> getWeeklyReport();
    List<MonthlyGameStatisticsReport> getMonthlyReport();
    List<YearlyGameStatisticsReport> getYearlyReport();
}
