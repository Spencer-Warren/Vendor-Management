import { HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Dish } from 'src/app/models/dish';
import { Restaurant } from 'src/app/models/restaurant';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-vendor-dishes',
  templateUrl: './vendor-dishes.component.html',
  styleUrls: ['./vendor-dishes.component.css']
})
export class VendorDishesComponent {
  restaurant!: Restaurant;
  dishes!: Dish[];

  constructor(private restAPI: RESTAPIService, private router: Router) {this.getRestaurant();}
  
  

  ngOnInit(): void {
  }

  getRestaurant() {
    // Get the restaurant ID from the URL
    let id: Number = parseInt(this.router.url.split('/')[3]);
    // Get the restaurant from the REST API
    this.restAPI.getRestaurant(id).subscribe((data: any) => {
      this.restaurant = data;
      this.getDishes();
    });
  }

  getDishes() {
    this.restAPI.getDishes(this.restaurant.restaurantID).subscribe((data: any) => {
      this.dishes = data;
    });
  }

  toCreate() {
    this.router.navigate(['/vendor/restaurants/' + this.restaurant.restaurantID + '/dishes/create']);
  }

  toEdit(dish: Dish) {
    this.router.navigate(['/vendor/restaurants/' + this.restaurant.restaurantID + '/dishes/edit/' + dish.dishID]);
  }

  toDelete(dish: Dish) {
    console.log(dish);
    if (confirm("Are you sure you want to delete: " + dish.dishName + "?" )) {
      this.restAPI.deleteDish(dish.dishID).subscribe((data: HttpResponse<any>) => console.log(data.body)
      );
      this.getDishes();
    }
  }
}
