package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.Review;
import com.rich.onlinegamesshop.repository.ReviewRepository;
import com.rich.onlinegamesshop.service.modelService.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getReviewById(Integer id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public void insertReview(Integer rating, String comment, Integer idCostumer, Integer idGame) {
        reviewRepository.insertReview(rating, comment, idCostumer, idGame);
    }
}
