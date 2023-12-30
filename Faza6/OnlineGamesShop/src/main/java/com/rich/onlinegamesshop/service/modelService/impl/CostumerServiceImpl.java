package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.Costumer;
import com.rich.onlinegamesshop.repository.CostumerRepository;
import com.rich.onlinegamesshop.service.modelService.CostumerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerServiceImpl implements CostumerService {
    private final CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public List<Costumer> getAllCostumers() {
        return costumerRepository.findAll();
    }
}
