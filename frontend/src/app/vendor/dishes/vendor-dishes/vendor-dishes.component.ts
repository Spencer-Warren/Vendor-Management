import { HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Dish } from 'src/app/models/dish';
import { Restaurant } from 'src/app/models/restaurant';
import { RESTAPIService } from 'src/app/services/restapi.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-vendor-dishes',
  templateUrl: './vendor-dishes.component.html',
  styleUrls: ['./vendor-dishes.component.css']
})
export class VendorDishesComponent {
  restaurant!: Restaurant;
  dishes!: Dish[];

  constructor(private restAPI: RESTAPIService, private router: Router, private restaurantService: RestaurantsService) {
    this.restaurant = this.restaurantService.getCurrentRestaurant();
    this.getDishes();
  }

  getDishes() {
    this.restAPI.getDishes(this.restaurant.restaurantID).subscribe((data: any) => {
      this.dishes = data;
    });
  }

  toCreate() {
    this.router.navigate(['/vendor/restaurants/dishes/create']);
  }

  toEdit(dish: Dish) {
    this.restaurantService.setCurrentDish(dish);
    this.router.navigate(['/vendor/restaurants/dishes/edit']);
  }

  toDelete(dish: Dish) {
    if (confirm("Are you sure you want to delete: " + dish.dishName + "?")) {
      this.restAPI.deleteDish(dish.dishID)
        .subscribe(
        );
      this.getDishes();
    }
  }
}
