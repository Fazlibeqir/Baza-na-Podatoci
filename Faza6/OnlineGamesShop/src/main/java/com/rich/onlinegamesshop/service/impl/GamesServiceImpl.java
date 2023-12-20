package com.rich.onlinegamesshop.service.impl;

import com.rich.onlinegamesshop.model.Games;
import com.rich.onlinegamesshop.repository.GamesRepository;
import com.rich.onlinegamesshop.service.GamesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {
   private final GamesRepository gamesRepository;

    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Games> getAllGames() {
        return gamesRepository.findAll();
    }
}
