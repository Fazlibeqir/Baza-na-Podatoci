import {ComponentFixture, TestBed} from '@angular/core/testing';
import {StoreViewComponent} from './StoreView.component';

describe('StoreViewComponent', () => {
  let component: StoreViewComponent;
  let fixture: ComponentFixture<StoreViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StoreViewComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoreViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the StoreView component', () => {
    expect(component).toBeTruthy();
  });
});
