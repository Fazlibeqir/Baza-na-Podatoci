package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.Costumer;

import java.util.List;

public interface CostumerService {
    void addCostumer(Costumer costumer);
    List<Costumer> getAllCostumers();
 }
