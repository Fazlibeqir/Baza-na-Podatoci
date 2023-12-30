package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.Review;

public interface ReviewService {
    Review getReviewById(Integer id);
   void insertReview(Integer rating, String comment, Integer idCostumer, Integer idGame);
}
