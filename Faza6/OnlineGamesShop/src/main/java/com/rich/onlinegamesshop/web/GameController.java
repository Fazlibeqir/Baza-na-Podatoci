package com.rich.onlinegamesshop.web;

import com.rich.onlinegamesshop.model.views.StoreView;
import com.rich.onlinegamesshop.service.viewsService.StoreViewService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final StoreViewService storeViewService;

    public GameController(StoreViewService storeViewService) {
        this.storeViewService = storeViewService;
    }

//    @GetMapping
//    public ResponseEntity<List<Games>> getAllGames() {
//        List<Games> games = gamesService.getAllGames();
//        return new ResponseEntity<>(games, HttpStatus.OK);
//    }
    @GetMapping
    public List<StoreView> getAllGames(Model model) {
        //        model.addAttribute("games", storeViewService.getAllGamesFromStoreView());
//        return "addGame";
        return storeViewService.getAllGamesFromStoreView();
    }
}
