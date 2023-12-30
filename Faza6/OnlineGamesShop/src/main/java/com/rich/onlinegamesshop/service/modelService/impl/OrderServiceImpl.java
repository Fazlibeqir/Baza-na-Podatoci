package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.reports.MonthlyGameStatisticsReport;
import com.rich.onlinegamesshop.model.reports.WeeklySalesReport;
import com.rich.onlinegamesshop.model.reports.YearlyGameStatisticsReport;
import com.rich.onlinegamesshop.repository.GamesRepository;
import com.rich.onlinegamesshop.repository.OrdersRepository;
import com.rich.onlinegamesshop.repository.PromotionsRepository;
import com.rich.onlinegamesshop.service.modelService.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrdersRepository orderRepository;
    private final GamesRepository gamesRepository;
    private final PromotionsRepository promotionsRepository;

    public OrderServiceImpl(OrdersRepository orderRepository, GamesRepository gamesRepository, PromotionsRepository promotionsRepository) {
        this.orderRepository = orderRepository;
        this.gamesRepository = gamesRepository;
        this.promotionsRepository = promotionsRepository;
    }

    @Override
    @Transactional
    public void insertOrder(String status, LocalDate orderDate, BigDecimal totalAmount, Integer idCostumer, Integer idPayment, Integer[] gameIds, Integer[] promotionIds) {
        Integer newOrderId=this.orderRepository.insertOrder(
                status,
                orderDate,
                totalAmount,
                idCostumer,
                idPayment,
                gameIds,
                promotionIds);
        if (newOrderId==null || newOrderId==0){
            throw new IllegalStateException("Order insertion failed");
        }
    }

    @Override
    public List<WeeklySalesReport> getWeeklyReport() {
        List<Object[]> result= this.orderRepository.getWeeklySalesReport();
        List<WeeklySalesReport> reports=new ArrayList<>();
        for (Object[] row : result) {
            String username = (String) row[0];
            BigDecimal weekNumber =( BigDecimal) row[1];
            Long totalOrders = (Long) row[2];
            BigDecimal totalSales = (BigDecimal) row[3];

            WeeklySalesReport report = new WeeklySalesReport(username, weekNumber, totalOrders, totalSales);
            reports.add(report);
        }
        return reports;
    }

    @Override
    public List<MonthlyGameStatisticsReport> getMonthlyReport() {
        List<Object[]> result= this.orderRepository.getMonthlyGameStatisticsReport();
        List<MonthlyGameStatisticsReport> reports=new ArrayList<>();
        for (Object[] row : result) {
            String genre = (String) row[0];
            String publisher = (String) row[1];
            BigDecimal monthNumber = (BigDecimal) row[2];
            long totalReviews = (long) row[3];
            BigDecimal totalRevenue = (BigDecimal) row[4];

            MonthlyGameStatisticsReport report = new MonthlyGameStatisticsReport(genre, publisher, monthNumber, totalReviews, totalRevenue);
            reports.add(report);
        }
        return reports;
    }

    @Override
    public List<YearlyGameStatisticsReport> getYearlyReport() {
        List<Object[]> result= this.orderRepository.getYearlyGameStatisticsReport();
        List<YearlyGameStatisticsReport> reports=new ArrayList<>();
        for (Object[] row : result) {
            String title = (String) row[0];
            BigDecimal yearNumber = (BigDecimal) row[1];
            long totalPlatforms = (long) row[2];
            BigDecimal averageRating = (BigDecimal) row[3];
            BigDecimal totalSales = (BigDecimal) row[4];

            YearlyGameStatisticsReport report = new YearlyGameStatisticsReport(title, yearNumber, totalPlatforms, averageRating, totalSales);
            reports.add(report);
        }
        return reports;
    }

}
