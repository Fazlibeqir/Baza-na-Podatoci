package com.rich.onlinegamesshop.web;


import com.rich.onlinegamesshop.model.Platform;
import com.rich.onlinegamesshop.model.Publisher;
import com.rich.onlinegamesshop.service.modelService.GameService;
import com.rich.onlinegamesshop.service.modelService.PlatformService;
import com.rich.onlinegamesshop.service.modelService.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GamesController {
    private final GameService gameService;
    private final PublisherService publisherService;
    private final PlatformService platformService;

    @Autowired
    public GamesController(GameService gameService, PublisherService publisherService, PlatformService platformService) {
        this.gameService = gameService;
        this.publisherService = publisherService;
        this.platformService = platformService;
    }

    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }
    @GetMapping("/platforms")
    public ResponseEntity<List<Platform>> getAllPlatforms(){
        return ResponseEntity.ok(platformService.getAllPlatforms());
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

          Integer idPublisher = Integer.parseInt((String)  gameData.get("idPublisher"));
          Integer idPlatform = Integer.parseInt((String) gameData.get("idPlatform"));

          gameService.insertGame(title, genre, price, developer, stock, releaseDate, idPublisher, idPlatform);
          return ResponseEntity.ok("Game inserted successfully");
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game insertion failed");
      }
    }
}
