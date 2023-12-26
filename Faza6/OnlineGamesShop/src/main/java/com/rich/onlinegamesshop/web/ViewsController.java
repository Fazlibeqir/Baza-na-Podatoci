package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.model.views.GameReviewsView;
import com.rich.onlinegamesshop.model.views.StoreView;
import com.rich.onlinegamesshop.model.views.UserLibraryView;
import com.rich.onlinegamesshop.service.viewsService.GameReviewsViewService;
import com.rich.onlinegamesshop.service.viewsService.StoreViewService;
import com.rich.onlinegamesshop.service.viewsService.UserLibraryViewService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ViewsController {

    private final StoreViewService storeViewService;
    private final UserLibraryViewService userLibraryViewService;
    private final GameReviewsViewService gameReviewsViewService;

    public ViewsController(StoreViewService storeViewService,
                           UserLibraryViewService userLibraryViewService,
                           GameReviewsViewService gameReviewsViewService) {
        this.storeViewService = storeViewService;
        this.userLibraryViewService = userLibraryViewService;
        this.gameReviewsViewService = gameReviewsViewService;
    }

//    @GetMapping
//    public ResponseEntity<List<Games>> getAllGames() {
//        List<Games> games = gamesService.getAllGames();
//        return new ResponseEntity<>(games, HttpStatus.OK);
//    }
    @GetMapping("/games")
    public List<StoreView> getAllGames(Model model) {
        //        model.addAttribute("games", storeViewService.getAllGamesFromStoreView());
//        return "addGame";
        return storeViewService.getAllGamesFromStoreView();
    }
    @GetMapping("/library")
    public List<UserLibraryView> getUserLibrary(Model model) {
//        model.addAttribute("games", ulvCostumeService.getUserLibraryView());
        return userLibraryViewService.getUserLibraryView();
    }
    @GetMapping("/Reviews")
    public List<GameReviewsView> getGameReviews(Model model) {
//        model.addAttribute("games", ulvCostumeService.getUserLibraryView());
        return gameReviewsViewService.getAllReviewsWithGames();
    }
}
