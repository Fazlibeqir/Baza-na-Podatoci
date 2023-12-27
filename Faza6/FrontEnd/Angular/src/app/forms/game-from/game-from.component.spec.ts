import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GameFromComponent } from './game-from.component';

describe('GameFromComponent', () => {
  let component: GameFromComponent;
  let fixture: ComponentFixture<GameFromComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GameFromComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GameFromComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
