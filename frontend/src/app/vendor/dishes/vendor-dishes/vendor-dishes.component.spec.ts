import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorDishesComponent } from './vendor-dishes.component';

describe('VendorDishesComponent', () => {
  let component: VendorDishesComponent;
  let fixture: ComponentFixture<VendorDishesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VendorDishesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VendorDishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
