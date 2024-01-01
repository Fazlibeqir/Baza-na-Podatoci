package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.model.Costumer;
import com.rich.onlinegamesshop.model.Payment;
import com.rich.onlinegamesshop.service.modelService.CostumerService;
import com.rich.onlinegamesshop.service.modelService.OrderService;
import com.rich.onlinegamesshop.service.modelService.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrdersController {
    private final OrderService orderService;
    private final CostumerService costumerService;
    private final PaymentService paymentService;

    public OrdersController(OrderService orderService, CostumerService costumerService, PaymentService paymentService) {
        this.orderService = orderService;
        this.costumerService = costumerService;
        this.paymentService = paymentService;
    }
    @GetMapping("/costumers")
    public ResponseEntity<List<Costumer>> getAllCostumers(){
        return ResponseEntity.ok(costumerService.getAllCostumers());
    }
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Map<String,Object> orderData){
        try {
            String status = (String) orderData.get("status");
            LocalDate orderDate = LocalDate.parse((String) orderData.get("orderDate"));
            BigDecimal totalAmount= new BigDecimal(String.valueOf(orderData.get("totalAmount")));
            Integer idCostumer = Integer.valueOf((String) orderData.get("idCostumer"));
            Integer idPayment =  Integer.valueOf((String) orderData.get("idPayment"));

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
