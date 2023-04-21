import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorRestaurantComponent } from './vendor-restaurant.component';

describe('VendorRestaurantComponent', () => {
  let component: VendorRestaurantComponent;
  let fixture: ComponentFixture<VendorRestaurantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VendorRestaurantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VendorRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
