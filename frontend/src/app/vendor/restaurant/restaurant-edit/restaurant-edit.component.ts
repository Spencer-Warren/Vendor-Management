import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/models/restaurant';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RESTAPIService } from 'src/app/services/restapi.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-restaurant-edit',
  templateUrl: './restaurant-edit.component.html',
  styleUrls: ['./restaurant-edit.component.css']
})
export class RestaurantEditComponent {
  restaurantForm!: FormGroup;
  oldRestaurant!: Restaurant;

  constructor(private restAPI: RESTAPIService, private router: Router, private authService: AuthenticationService, private restaurantService: RestaurantsService) { }

  ngOnInit(): void {

    this.restaurantForm = new FormBuilder().group({
      restaurantName: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      restaurantAddress: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      restaurantPhone: new FormControl <string> ('', [Validators.minLength(3), Validators.maxLength(50)]),
      restaurantEmail: new FormControl <string> ('', [Validators.required, Validators.email]),
      restaurantDescription: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      restaurantCategory: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      restaurantType: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)])
    });

    this.getRestaurant();
  }

  getRestaurant() {
    let restaurant: Restaurant = this.restaurantService.getCurrentRestaurant();
    // Get the restaurant from the REST API
    this.restAPI.getRestaurant(restaurant.restaurantID).subscribe((data: any) => {
      this.oldRestaurant = data;
      // Set the form values to the restaurant values
      this.restaurantForm.patchValue({
        restaurantName: this.oldRestaurant.restaurantName,
        restaurantAddress: this.oldRestaurant.restaurantAddress,
        restaurantPhone: this.oldRestaurant.restaurantPhone,
        restaurantEmail: this.oldRestaurant.restaurantEmail,
        restaurantDescription: this.oldRestaurant.restaurantDescription,
        restaurantCategory: this.oldRestaurant.restaurantCategory,
        restaurantType: this.oldRestaurant.restaurantType
      });
    });
  }

  onSubmit() {
    if (this.restaurantForm.valid) {
      // Create a new restaurant object from the form values
      let restaurant: Restaurant = this.restaurantForm.value;
      // Set the vendor to the current vendor
      restaurant.vendor = this.authService.currentVendor;
      // Set the restaurant ID to the old restaurant ID
      restaurant.restaurantID = this.oldRestaurant.restaurantID;
      // Update the restaurant
      this.restAPI.updateRestaurant(restaurant)
      .subscribe(
        (data: any) => {
          alert("Restaurant has been updated!");
          this.router.navigate(["/vendor/restaurants"]);
        }
      );
    }
  }

  onBack() {
    this.router.navigate(["/vendor/restaurants"]);
  }
}
