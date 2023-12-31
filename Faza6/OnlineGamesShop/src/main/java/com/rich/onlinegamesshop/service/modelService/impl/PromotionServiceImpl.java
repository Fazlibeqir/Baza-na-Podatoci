package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.Promotions;
import com.rich.onlinegamesshop.repository.PromotionsRepository;
import com.rich.onlinegamesshop.service.modelService.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    private final PromotionsRepository promotionsRepository;

    public PromotionServiceImpl(PromotionsRepository promotionsRepository) {
        this.promotionsRepository = promotionsRepository;
    }

    @Override
    public List<Promotions> getAllPromotions() {
        return promotionsRepository.findAll();
    }

    @Override
    public void addPromotion(Promotions promotion) {
        promotionsRepository.save(promotion);
    }
}
