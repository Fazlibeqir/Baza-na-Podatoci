package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.service.modelService.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Map<String,Object> orderData){
        try {
            String status = (String) orderData.get("status");
            LocalDate orderDate = LocalDate.parse((String) orderData.get("orderDate"));
            BigDecimal totalAmount= new BigDecimal(String.valueOf(orderData.get("totalAmount")));
            Integer idCostumer = (Integer) orderData.get("idCostumer");
            Integer idPayment = (Integer) orderData.get("idPayment");

            List<Integer> idsGameStrings= (List<Integer>) orderData.get("idGame"); //TODO:
            List<Integer> idsPromotionStrings= (List<Integer>) orderData.get("idPromotion"); //TODO:
            Integer[] idGame = idsGameStrings.toArray(Integer[]::new);
            Integer[] idPromotion =idsPromotionStrings.toArray(Integer[]::new);

            orderService.insertOrder(status, orderDate, totalAmount, idCostumer, idPayment, idGame, idPromotion);
            return ResponseEntity.ok("Order added successfully");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Order insertion failed");
        }
    }
}
