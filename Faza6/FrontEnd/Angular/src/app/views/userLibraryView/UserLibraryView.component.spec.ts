import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLibraryViewComponent } from './UserLibraryView.component';

describe('UserLibraryViewComponent', () => {
  let component: UserLibraryViewComponent;
  let fixture: ComponentFixture<UserLibraryViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserLibraryViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserLibraryViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
