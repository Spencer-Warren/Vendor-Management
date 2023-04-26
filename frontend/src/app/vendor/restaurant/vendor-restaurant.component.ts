import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/classes/restaurant';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-vendor-restaurant',
  templateUrl: './vendor-restaurant.component.html',
  styleUrls: ['./vendor-restaurant.component.css']
})
export class VendorRestaurantComponent {

  restaurants: Array<Restaurant> = [];

  constructor(private RestAPI: RESTAPIService, private router: Router) { }

  ngOnInit(): void {
    this.getAllRestaurants();
  }

  getAllRestaurants() {
    let id = sessionStorage.getItem("vendorId");
    this.RestAPI.getAllRestaurants(id).subscribe((data: any) => {
      this.restaurants = data;
      console.log(this.restaurants);
    });
  }
  
  toCreate() {
    this.router.navigate(['/vendor/restaurants/create']);
  }

  toEdit(id: Number) {
    this.router.navigate(['/vendor/restaurants/edit/' + id]);
  }

  delete(id: Number, name: String) {
    if (confirm("Are you sure you want to delete: " + name + "?" )) {
      this.RestAPI.deleteRestaurant(id).subscribe((data) => console.log(data));
      this.router.navigate(['/vendor/restaurants']);
      console.log(id + " : " + name);
    }
  }
}
