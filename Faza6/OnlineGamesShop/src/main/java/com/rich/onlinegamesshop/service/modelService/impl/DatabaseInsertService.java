package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.Games;
import com.rich.onlinegamesshop.model.Orders;
import com.rich.onlinegamesshop.model.Publisher;
import com.rich.onlinegamesshop.model.Review;
import com.rich.onlinegamesshop.repository.GamesRepository;
import com.rich.onlinegamesshop.repository.OrdersRepository;
import com.rich.onlinegamesshop.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@Transactional
public class DatabaseInsertService {
    private final GamesRepository gamesRepository;
    private final OrdersRepository ordersRepository;
    private final ReviewRepository reviewRepository;

    public DatabaseInsertService(GamesRepository gamesRepository, OrdersRepository ordersRepository, ReviewRepository reviewRepository) {
        this.gamesRepository = gamesRepository;
        this.ordersRepository = ordersRepository;
        this.reviewRepository = reviewRepository;
    }
    public void insertGames(String title, String genre, BigDecimal price, String developer, int stock, LocalDate releaseDate, Publisher publisher1){
        Games game =new Games();
        game.setTitle(title);
        game.setGenre(genre);
        game.setPrice(price);
        game.setDeveloper(developer);
        game.setStock(stock);
        game.setReleaseDate(releaseDate);
        Publisher publisher2=new Publisher();
        publisher2.setId_publisher(publisher1.getId_publisher());
        publisher2.setName(publisher1.getName());
        publisher2.setWebsite(publisher1.getWebsite());
        publisher2.setCountry(publisher1.getCountry());
        game.setPublisher(publisher2);
        gamesRepository.save(game);
    }
    public void insertOrder(String status, LocalDate orderDate, BigDecimal totalAmount, Long idCustomer, Long idPayment){
        Orders orders=new Orders();
        orders.setStatus(status);
        orders.setOrderDate(orderDate);
        orders.setTotalAmount(totalAmount);
        orders.setCostumer(idCustomer);
        orders.setPayment(idPayment);
        ordersRepository.save(orders);
    }
    public void insertReview(Integer rating, String comment, Long idCustomer, Long idGame){
        Review review=new Review();
        review.setRating(rating);
        review.setComment(comment);
        review.setCostumer(idCustomer);
        review.setGames(idGame);
        reviewRepository.save(review);
    }
}
