package com.rich.onlinegamesshop.service.viewsService.viewsImpl;

import com.rich.onlinegamesshop.model.views.StoreView;
import com.rich.onlinegamesshop.repository.viewsRepo.Impl.SVRCostum;
import com.rich.onlinegamesshop.service.viewsService.StoreViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreViewServiceImpl implements StoreViewService {
    private final SVRCostum svrCostum;

    public StoreViewServiceImpl(SVRCostum svrCostum) {
        this.svrCostum = svrCostum;
    }

    @Override
    public List<StoreView> getAllGamesFromStoreView() {
        return this.svrCostum.findAll();
    }
}
