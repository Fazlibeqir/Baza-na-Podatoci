package com.rich.onlinegamesshop.repository;

import com.rich.onlinegamesshop.model.Orders;
import com.rich.onlinegamesshop.model.reports.WeeklySalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
    @Query(value = "SELECT c.username," +
            "extract(WEEK FROM o.order_date) as weekNumber, " +
            "COUNT(o.id_order) as totalOrder," +
            "SUM(o.total_amount)as totalAmount " +
            "FROM Orders o " +
            "JOIN costumer c on o.id_costumer = c.id_costumer " +
            "GROUP BY weekNumber, c.username " +
            "ORDER BY weekNumber, totalAmount DESC"
            , nativeQuery = true)
    List<Object[]> getWeeklySalesReport();

    @Query(value = "SELECT G.genre, " +
            "P.name as publisher, " +
            "extract(MONTH FROM o.order_date) as monthNumber, " +
            "count(R.id_review) as totalReviews," +
            "sum(o.total_amount)as totalRevenue " +
            "FROM Orders o " +
            "JOIN orders_contains_games as OG on o.id_order = OG.id_order " +
            "JOIN games as G on OG.id_game = G.id_game " +
            "JOIN publisher as P on G.id_publisher = P.id_publisher " +
            "LEFT JOIN review as R on G.id_game = R.id_game " +
            "GROUP BY  monthNumber, G.genre, P.name " +
            "ORDER BY monthNumber, totalRevenue DESC, totalReviews DESC"
            , nativeQuery = true)
    List<Object[]> getMonthlyGameStatisticsReport();

    @Query(value = "SELECT G.title," +
            "extract(YEAR FROM o.order_date) as yearNumber, " +
            "COUNT(DISTINCT GP.id_platform) as totalPlatfroms," +
            "avg(R.rating)as averageRating, " +
            "SUM(o.total_amount)as totalSales " +
            "FROM Orders o " +
            "JOIN orders_contains_games as OG on o.id_order = OG.id_order " +
            "JOIN games as G on OG.id_game = G.id_game " +
            "JOIN review as R on G.id_game = R.id_game " +
            "LEFT JOIN games_supports_platform as GP on G.id_game=GP.id_game " +
            "GROUP BY yearNumber, G.title " +
            "ORDER BY yearNumber, totalSales DESC, averageRating DESC"
            , nativeQuery = true)
    List<Object[]> getYearlyGameStatisticsReport();

}
