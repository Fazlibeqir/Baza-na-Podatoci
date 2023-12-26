import {Component, OnInit} from '@angular/core';
import {GameReviewsView} from "../../model/GameReviewsView";
import {GameReviewsService} from "../../services/GameReviews.service";

@Component({
  selector: 'app-game-reviews',
  templateUrl: './GameReviews.component.html',
  styleUrls: ['./GameReviews.component.css']
})
export class GameReviewsComponent implements OnInit{
  gameReviewsViews: GameReviewsView[] = [];
  constructor(private GameReviewsService: GameReviewsService) {}
  ngOnInit(): void {
    this.GameReviewsService.getAllGameReviews().subscribe((data: GameReviewsView[]) => {
      this.gameReviewsViews = data;
    });
    }
  }
