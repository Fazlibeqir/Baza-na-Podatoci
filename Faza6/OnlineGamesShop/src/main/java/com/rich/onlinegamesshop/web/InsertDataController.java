package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.service.modelService.impl.DatabaseInsertService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/insert")
public class InsertDataController {
    private final DatabaseInsertService insertService;

    public InsertDataController(DatabaseInsertService insertService) {
        this.insertService = insertService;
    }
    @PostMapping("/games")
    public String insertGames(@RequestBody GameInsertRequest request){
        insertService.insertGames(request.getTitle(), request.getGenre(), request.getPrice(),
                request.getDeveloper(), request.getStock(), LocalDate.parse(request.getReleaseDate()), request.getIdPublisher());
        return "Game inserted successfully!";
    }
    @PostMapping("/order")
    public String insertOrders(@RequestBody OrderInsertRequest request){
        insertService.insertOrder(request.getStatus(), request.getOrderDate(), request.getTotalAmount(),
                request.getIdCustomer(), request.getIdPayment());
        return "Order inserted successfully!";
    }
    @PostMapping("/review")
    public String insertReviews(@RequestBody ReviewInsertRequest request){
        insertService.insertReview(request.getRating(), request.getComment(),
                request.getIdCustomer(), request.getIdGame());
        return "Review inserted successfully!";
    }
    @Data
    public static class GameInsertRequest{
        private String title;
        private String genre;
        private BigDecimal price;
        private String developer;
        private int stock;
        private String releaseDate;
        private Integer idPublisher;
    }
    @Data
    public static class OrderInsertRequest {
        // Include fields for order insertion
        private String status;
        private LocalDate orderDate;
        private BigDecimal totalAmount;
        private Integer idCustomer;
        private Integer idPayment;
    }
    @Data
    public static class ReviewInsertRequest {
        private Integer rating;
        private String comment;
        private Integer idCustomer;
        private Integer idGame;

    }
}
