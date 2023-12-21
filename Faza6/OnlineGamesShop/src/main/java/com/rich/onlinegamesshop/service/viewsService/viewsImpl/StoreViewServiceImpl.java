package com.rich.onlinegamesshop.service.viewsService.viewsImpl;

import com.rich.onlinegamesshop.model.views.StoreView;
import com.rich.onlinegamesshop.repository.viewsRepo.Impl.StoreViewRepository;
import com.rich.onlinegamesshop.service.viewsService.StoreViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreViewServiceImpl implements StoreViewService {
    private final StoreViewRepository storeViewRepository;

    public StoreViewServiceImpl(StoreViewRepository storeViewRepository) {
        this.storeViewRepository = storeViewRepository;
    }

    @Override
    public List<StoreView> getAllGamesFromStoreView() {
        return this.storeViewRepository.findAll();
    }
}
