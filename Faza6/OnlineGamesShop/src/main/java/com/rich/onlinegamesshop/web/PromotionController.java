package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.model.Promotions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rich.onlinegamesshop.service.modelService.PromotionService;

import java.util.List;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Promotions>> getAllPromotions(){
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }
}
