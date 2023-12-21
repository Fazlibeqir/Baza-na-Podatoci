package com.rich.onlinegamesshop.service.viewsService.viewsImpl;

import com.rich.onlinegamesshop.model.views.GameReviewsView;
import com.rich.onlinegamesshop.repository.viewsRepo.Impl.GameReviewsViewRepository;
import com.rich.onlinegamesshop.service.viewsService.GameReviewsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameReviewsViewServiceImpl implements GameReviewsViewService {
    private final GameReviewsViewRepository gameReviewsViewRepository;

    public GameReviewsViewServiceImpl(GameReviewsViewRepository gameReviewsViewRepository) {
        this.gameReviewsViewRepository = gameReviewsViewRepository;
    }

    @Override
    public List<GameReviewsView> getAllReviewsWithGames() {
        return this.gameReviewsViewRepository.findAllGameReviews();
    }
}
