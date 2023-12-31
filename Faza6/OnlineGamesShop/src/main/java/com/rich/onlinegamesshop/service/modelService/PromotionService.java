package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.Promotions;

import java.util.List;

public interface PromotionService {
    List<Promotions> getAllPromotions();
    void addPromotion(Promotions promotion);
}
