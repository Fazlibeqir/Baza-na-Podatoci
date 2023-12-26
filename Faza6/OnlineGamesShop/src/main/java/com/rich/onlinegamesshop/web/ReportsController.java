package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.model.reports.MonthlyGameStatisticsReport;
import com.rich.onlinegamesshop.model.reports.WeeklySalesReport;
import com.rich.onlinegamesshop.model.reports.YearlyGameStatisticsReport;
import com.rich.onlinegamesshop.service.modelService.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportsController {
    private final OrderService orderService;

    public ReportsController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/weeklyReport")
    public List<WeeklySalesReport> getWeeklyReport() {
        return this.orderService.getWeeklyReport();
    }
    @GetMapping("/monthlyReport")
    public List<MonthlyGameStatisticsReport> getMonthlyReport() {
        return this.orderService.getMonthlyReport();
    }
    @GetMapping("/yearlyReport")
    public List<YearlyGameStatisticsReport> getYearlyReport() {
        return this.orderService.getYearlyReport();
    }
}
