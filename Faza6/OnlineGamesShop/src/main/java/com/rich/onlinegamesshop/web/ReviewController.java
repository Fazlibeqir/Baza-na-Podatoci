package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.model.Costumer;
import com.rich.onlinegamesshop.model.Games;
import com.rich.onlinegamesshop.service.modelService.CostumerService;
import com.rich.onlinegamesshop.service.modelService.GameService;
import com.rich.onlinegamesshop.service.modelService.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final GameService  gameService;
    private final CostumerService costumerService;

    public ReviewController(ReviewService reviewService, GameService gameService, CostumerService costumerService) {
        this.reviewService = reviewService;
        this.gameService = gameService;
        this.costumerService = costumerService;
    }
    @GetMapping("/games")
    public ResponseEntity<List<Games>> getAllGames(){
        return ResponseEntity.ok(gameService.getAllGames());
    }
    @GetMapping("/costumers")
    public ResponseEntity<List<Costumer>> getAllCostumers(){
        return ResponseEntity.ok(costumerService.getAllCostumers());
    }


    //TODO:Make a form inside the game and add the review there (idk if i do this)
    @PostMapping("/add")
    public ResponseEntity<String> addReview(@RequestBody Map<String,Object> reviewData){
       try {
           Integer rating = (Integer) reviewData.get("rating");
           String comment = (String) reviewData.get("comment");

        Integer idCostumer =Integer.parseInt((String) reviewData.get("idCostumer"));
        Integer idGame = Integer.parseInt((String) reviewData.get("idGame"));
        reviewService.insertReview(rating, comment, idCostumer, idGame);
        return ResponseEntity.ok("Review added successfully");
         }
       catch (Exception e){
              return ResponseEntity.badRequest().body("Review insertion failed");
        }
    }
}
