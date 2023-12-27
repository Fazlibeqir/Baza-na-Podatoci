package com.rich.onlinegamesshop.web;


import com.rich.onlinegamesshop.service.modelService.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GamesController {
    private final GameService gameService;

    @Autowired
    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> insertGame(@RequestBody Map<String,Object> gameData){
      try {
          String title = (String) gameData.get("title");
          String genre = (String) gameData.get("genre");
          BigDecimal price = new BigDecimal(String.valueOf(gameData.get("price")));
          String developer = (String) gameData.get("developer");
          int stock = (int) gameData.get("stock");
          LocalDate releaseDate = LocalDate.parse((String) gameData.get("releaseDate"));
          Integer idPublisher = (Integer) gameData.get("idPublisher");

          gameService.insertGame(title, genre, price, developer, stock, releaseDate, idPublisher);
          return ResponseEntity.ok("Game inserted successfully");
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game insertion failed");
      }
    }
}
