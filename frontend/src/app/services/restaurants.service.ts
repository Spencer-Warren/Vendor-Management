import { Injectable } from '@angular/core';
import { Restaurant } from '../models/restaurant';
import { RESTAPIService } from './restapi.service';
import { AuthenticationService } from './authentication.service';
import { Dish } from '../models/dish';
import { BehaviorSubject, Observable, Subject, firstValueFrom } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class RestaurantsService {

  private restaurants!: Array<Restaurant>; // Array of restaurants
  private currentRestaurant!: Restaurant; // Current restaurant
  private currentDish!: Dish; // Current dish

  constructor(private restAPI: RESTAPIService, private authService: AuthenticationService) { }

  // Get current restaurant
  getCurrentRestaurant(): Restaurant {
    return this.currentRestaurant;  
  }

  // Set current restaurant
  setCurrentRestaurant(restaurant: Restaurant) {
    this.currentRestaurant = restaurant;
  }

  getCurrentDish(): Dish {
    return this.currentDish;
  }

  setCurrentDish(dish: Dish) {
    this.currentDish = dish;
  }


  // Get all restaurants
  // Cache the restaurants
  // If the restaurants are not cached, fetch them from the server
  async getRestaurants(): Promise<Array<Restaurant>> {
    if (this.restaurants == null || this.restaurants.length == 0) {
      this.restaurants = await firstValueFrom(this.refetchRestaurants());
    }
    return this.restaurants;
  }

  refetchRestaurants(): Observable<Restaurant[]> {
    let id = sessionStorage.getItem("vendorId");
    return this.restAPI.getAllRestaurants(id);
  }

  // Clear all
  clearAll() {
    // this.restaurants = [];
    // delete this.currentRestaurant;
    // this.currentDish = null;
  }
  
}
