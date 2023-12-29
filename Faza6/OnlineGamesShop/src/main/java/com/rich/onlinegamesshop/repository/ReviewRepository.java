package com.rich.onlinegamesshop.repository;

import com.rich.onlinegamesshop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "SELECT insertReview(:_rating, :_comment, :_id_costumer, :_id_game)", nativeQuery = true)
    void insertReview(
            @Param("_rating") Integer rating,
            @Param("_comment") String comment,
            @Param("_id_costumer") Integer idCostumer,
            @Param("_id_game") Integer idGame);
}
