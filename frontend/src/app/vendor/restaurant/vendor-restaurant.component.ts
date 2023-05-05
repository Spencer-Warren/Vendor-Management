import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/models/restaurant';
import { RESTAPIService } from 'src/app/services/restapi.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-vendor-restaurant',
  templateUrl: './vendor-restaurant.component.html',
  styleUrls: ['./vendor-restaurant.component.css']
})
export class VendorRestaurantComponent {

  restaurants: Restaurant[] = [];
  visible: Map<Number, Boolean> = new Map<Number, Boolean>();

  constructor(private RestAPI: RESTAPIService, private router: Router, private restaurantService: RestaurantsService) { }

  ngOnInit(): void {
    this.getAllRestaurants();
  }

  async getAllRestaurants() {
    this.restaurants = await this.restaurantService.getRestaurants();
      console.log(this.restaurants);
      for (let i = 0; i < this.restaurants.length; i++) {
        this.visible.set(this.restaurants[i].restaurantID, false);
      }
  }

  toggleCollapse(id: Number) {
    if (this.visible.get(id) == true) {
      this.visible.set(id, false);
    } else {
      this.visible.set(id, true);
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

  toDishes(restaurant: Restaurant) {
    this.restaurantService.setCurrentRestaurant(restaurant);
    this.router.navigate(['/vendor/restaurants/dishes']);
  }

  delete(id: Number, name: String) {
    if (confirm("Are you sure you want to delete: " + name + "?" )) {
      this.RestAPI.deleteRestaurant(id).subscribe((data) => console.log(data));
      this.restaurants = this.restaurants.filter((restaurant) => restaurant.restaurantID != id);
      console.log(id + " : " + name);
    }
  }
}
