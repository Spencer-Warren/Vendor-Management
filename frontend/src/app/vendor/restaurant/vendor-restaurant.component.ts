import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/models/restaurant';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-vendor-restaurant',
  templateUrl: './vendor-restaurant.component.html',
  styleUrls: ['./vendor-restaurant.component.css']
})
export class VendorRestaurantComponent {

  restaurants: Array<Restaurant> = [];
  visable: Map<Number, Boolean> = new Map<Number, Boolean>();

  constructor(private RestAPI: RESTAPIService, private router: Router) { }

  ngOnInit(): void {
    this.getAllRestaurants();
  }

  getAllRestaurants() {
    let id = sessionStorage.getItem("vendorId");
    this.RestAPI.getAllRestaurants(id).subscribe((data: any) => {
      this.restaurants = data;
      for (let i = 0; i < this.restaurants.length; i++) {
        this.visable.set(this.restaurants[i].restaurantID, false);
      }
    });
  }

  toggleCollapse(id: Number) {
    if (this.visable.get(id) == true) {
      this.visable.set(id, false);
    } else {
      this.visable.set(id, true);
    }
  }
  
  toCreate() {
    this.router.navigate(['/vendor/restaurants/create']);
  }

  toEdit(id: Number) {
    this.router.navigate(['/vendor/restaurants/edit/' + id]);
  }

  toLicense(id: Number) {
    this.router.navigate(['/vendor/license-view/' + id]);
  }

  delete(id: Number, name: String) {
    if (confirm("Are you sure you want to delete: " + name + "?" )) {
      this.RestAPI.deleteRestaurant(id).subscribe((data) => console.log(data));
      this.restaurants = this.restaurants.filter((restaurant) => restaurant.restaurantID != id);
      console.log(id + " : " + name);
    }
  }
}
