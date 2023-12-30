import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderViewComponent } from './OrderView.component';

describe('UserLibraryViewComponent', () => {
  let component: OrderViewComponent;
  let fixture: ComponentFixture<OrderViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
