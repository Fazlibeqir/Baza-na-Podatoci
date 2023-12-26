import { TestBed } from '@angular/core/testing';

import { GameReviewsService } from './GameReviews.service';

describe('GameReviewsService', () => {
  let service: GameReviewsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GameReviewsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
