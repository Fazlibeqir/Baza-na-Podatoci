package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.reports.MonthlyGameStatisticsReport;
import com.rich.onlinegamesshop.model.reports.WeeklySalesReport;
import com.rich.onlinegamesshop.model.reports.YearlyGameStatisticsReport;

import java.util.List;

public interface OrderService {
    List<WeeklySalesReport> getWeeklyReport();
    List<MonthlyGameStatisticsReport> getMonthlyReport();
    List<YearlyGameStatisticsReport> getYearlyReport();
}
