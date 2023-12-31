package com.rich.onlinegamesshop.repository;

import com.rich.onlinegamesshop.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {
    @Query(value = "SELECT insertGame(:_title, :_genre, :_price, :_developer, :_stock, :_release_date, :_id_publisher,:_id_platform,:_image)", nativeQuery = true)
    void insertGame(
            @Param("_title") String title,
            @Param("_genre") String genre,
            @Param("_price") BigDecimal price,
            @Param("_developer") String developer,
            @Param("_stock") int stock,
            @Param("_release_date") LocalDate releaseDate,
            @Param("_id_publisher") Integer idPublisher,
            @Param("_id_platform") Integer idPlatform,
            @Param("_image") String image);

}
