package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.model.*;
import com.rich.onlinegamesshop.service.modelService.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityController {
    private final PromotionService promotionService;
    private final CostumerService costumerService;
    private final PlatformService platformService;
    private final PublisherService publisherService;
    private final PaymentService paymentService;

    public EntityController(PromotionService promotionService,
                            CostumerService costumerService,
                            PlatformService platformService,
                            PublisherService publisherService,
                            PaymentService paymentService) {
        this.promotionService = promotionService;
        this.costumerService = costumerService;
        this.platformService = platformService;
        this.publisherService = publisherService;
        this.paymentService = paymentService;
    }
    @PostMapping("/costumer/add")
    public ResponseEntity<String> addCostumer(@RequestBody Costumer costumer){
        try {
            costumerService.addCostumer(costumer);
            return ResponseEntity.ok("Costumer added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Costumer insertion failed");
        }
    }
    @PostMapping("/platform/add")
    public ResponseEntity<String> addPlatform(@RequestBody Platform platform){
        try {
            platformService.addPlatform(platform);
            return ResponseEntity.ok("Platform added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Platform insertion failed");
        }
    }

    @PostMapping("/promotion/add")
    public ResponseEntity<String> addPromotion(@RequestBody Promotions promotion){
        try {
            promotionService.addPromotion(promotion);
            return ResponseEntity.ok("Promotion added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Promotion insertion failed");
        }
    }
    @PostMapping("/publisher/add")
    public ResponseEntity<String> addPublisher(@RequestBody Publisher publisher){
        try {
            publisherService.addPublisher(publisher);
            return ResponseEntity.ok("Publisher added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Publisher insertion failed");
        }
    }
    @PostMapping("/payment/add")
    public ResponseEntity<String> addPayment(@RequestBody Payment payment){
        try {
            paymentService.addPayment(payment);
            return ResponseEntity.ok("Payment added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Payment insertion failed");
        }
    }
}
