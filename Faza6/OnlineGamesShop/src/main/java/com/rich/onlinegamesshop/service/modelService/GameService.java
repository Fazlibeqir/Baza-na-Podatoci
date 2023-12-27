package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.Games;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface GameService {
    void insertGame(String title, String genre, BigDecimal price, String developer, int stock, LocalDate releaseDate, Integer idPublisher);
}
