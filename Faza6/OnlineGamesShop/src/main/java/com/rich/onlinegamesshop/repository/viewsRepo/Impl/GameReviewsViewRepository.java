package com.rich.onlinegamesshop.repository.viewsRepo.Impl;

import com.rich.onlinegamesshop.model.views.GameReviewsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameReviewsViewRepository extends JpaRepository<GameReviewsView,Integer> {
    @Query(value = "SELECT * FROM gamereviewsview", nativeQuery = true)
    List<GameReviewsView> findAllGameReviews();
}
