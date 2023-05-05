import { Injectable } from '@angular/core';
import { Restaurant } from '../models/restaurant';
import { RESTAPIService } from './restapi.service';
import { AuthenticationService } from './authentication.service';



@Injectable({
  providedIn: 'root'
})
export class RestaurantsService {

  private restaurants!: Restaurant[]; // Array of restaurants'
  private currentRestaurant!: Restaurant; // Current restaurant

  constructor(private restAPI: RESTAPIService, private authService: AuthenticationService) { }

  // Get current restaurant
  getCurrentRestaurant(): Restaurant {
    return this.currentRestaurant;  
  }

  // Set current restaurant
  setRestaurant(restaurant: Restaurant) {
    this.currentRestaurant = restaurant;
  }

  // Get all restaurants
  getRestaurants(): Restaurant[] {
    return this.restaurants;
  }

  // Get a restaurant by ID
  getRestaurant(id: number): Restaurant {
    return this.restaurants.find(restaurant => restaurant.restaurantID == id)!;
  }

  refetchRestaurants() {
    let id = sessionStorage.getItem("vendorId");
    this.restAPI.getAllRestaurants(id)
    .subscribe(
      (data: Restaurant[]) => {
        this.restaurants = data;
      }
    );
  }
}
