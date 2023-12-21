package com.rich.onlinegamesshop.service.viewsService;

import com.rich.onlinegamesshop.model.views.GameReviewsView;

import java.util.List;

public interface GameReviewsViewService {
    List<GameReviewsView> getAllReviewsWithGames();
}
