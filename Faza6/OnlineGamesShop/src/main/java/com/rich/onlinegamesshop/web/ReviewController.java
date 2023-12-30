package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.service.modelService.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    //TODO:Make on the game view a list of reviews
    @GetMapping("/{id}")
    public ResponseEntity<Object> getReviewById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(reviewService.getReviewById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Review not found");
        }
    }
    //TODO:Make a form inside the game and add the review there
    @PostMapping("/add")
    public ResponseEntity<String> addReview(@RequestBody Map<String,Object> reviewData){
       try {
           Integer rating = (Integer) reviewData.get("rating");
           String comment = (String) reviewData.get("comment");

        Integer idCostumer = (Integer) reviewData.get("idCostumer");
        Integer idGame = (Integer) reviewData.get("idGame");
        reviewService.insertReview(rating, comment, idCostumer, idGame);
        return ResponseEntity.ok("Review added successfully");
         }
       catch (Exception e){
              return ResponseEntity.badRequest().body("Review insertion failed");
        }
    }
}
