package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.*;
import com.rich.onlinegamesshop.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DatabaseInsertService {
    private final GamesRepository gamesRepository;
    private final OrdersRepository ordersRepository;
    private final ReviewRepository reviewRepository;
    private final CostumerRepository costumerRepository;
    private final PaymentRepository paymentRepository;
    private final PublisherRepository publisherRepository;

    public DatabaseInsertService(GamesRepository gamesRepository, OrdersRepository ordersRepository, ReviewRepository reviewRepository,
                                 CostumerRepository costumerRepository,
                                 PaymentRepository paymentRepository,
                                 PublisherRepository publisherRepository) {
        this.gamesRepository = gamesRepository;
        this.ordersRepository = ordersRepository;
        this.reviewRepository = reviewRepository;
        this.costumerRepository = costumerRepository;
        this.paymentRepository = paymentRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public void insertGames(String title, String genre, BigDecimal price, String developer, int stock, LocalDate releaseDate, Integer idPublisher){
        Games game =new Games();
        game.setTitle(title);
        game.setGenre(genre);
        game.setPrice(price);
        game.setDeveloper(developer);
        game.setStock(stock);
        game.setReleaseDate(releaseDate);
        Publisher publisher=publisherRepository.findById(idPublisher).orElseThrow(()->new EntityNotFoundException("Publisher not found"));
        game.setPublisher(publisher);
        gamesRepository.save(game);
        gamesRepository.flush();
    }

    @Transactional
    public void insertOrder(String status, LocalDate orderDate, BigDecimal totalAmount, Integer idCustomer, Integer idPayment){
        Orders orders=new Orders();
        orders.setStatus(status);
        orders.setOrderDate(orderDate);
        orders.setTotalAmount(totalAmount);

        Costumer costumer=costumerRepository.findById(idCustomer).orElseThrow(()->new EntityNotFoundException("Costumer not found"));
        Payment payment= paymentRepository.findById(idPayment).orElseThrow(()->new EntityNotFoundException("Payment not found"));
        orders.setCostumer(costumer);
        orders.setPayment(payment);
        ordersRepository.save(orders);
        ordersRepository.flush();
    }

    @Transactional
    public void insertReview(Integer rating, String comment, Integer idCustomer, Integer idGame){
        Review review=new Review();
        review.setRating(rating);
        review.setComment(comment);

        Costumer costumer=costumerRepository.findById(idCustomer).orElseThrow(()->new EntityNotFoundException("Costumer not found"));
        Games game=gamesRepository.findById(idGame).orElseThrow(()->new EntityNotFoundException("Game not found"));
        review.setCostumer(costumer);
        review.setGames(game);
        reviewRepository.save(review);
        reviewRepository.flush();
    }
}
