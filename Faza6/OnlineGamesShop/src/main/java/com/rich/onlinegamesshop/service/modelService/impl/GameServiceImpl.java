package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.repository.GamesRepository;
import com.rich.onlinegamesshop.service.modelService.GameService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@Transactional
public class GameServiceImpl implements GameService {
   private final GamesRepository gamesRepository;

    public GameServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public void insertGame(String title, String genre, BigDecimal price, String developer, int stock, LocalDate releaseDate, Integer idPublisher) {
        gamesRepository.insertGame(title, genre,
                price, developer,
                stock,
                releaseDate,
                idPublisher);
    }
}
