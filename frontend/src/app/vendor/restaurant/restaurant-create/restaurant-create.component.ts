import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/models/restaurant';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-restaurant-create',
  templateUrl: './restaurant-create.component.html',
  styleUrls: ['./restaurant-create.component.css']
})
export class RestaurantCreateComponent {
  restaurantForm!: FormGroup;

    constructor(private restAPI: RESTAPIService, private router: Router, private authService: AuthenticationService) { }
  
    ngOnInit(): void {
      this.restaurantForm = new FormBuilder().group({
        restaurantName: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        restaurantAddress: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        restaurantPhone: new FormControl <string> ('', [Validators.minLength(3), Validators.maxLength(50)]),
        restaurantEmail: new FormControl <string> ('', [Validators.required, Validators.email]),
        restaurantDescription: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(1000)]),
        restaurantCategory: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        restaurantType: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)])
        });
    }

    onSubmit() {
      if (this.restaurantForm.valid) {
        let restaurant = this.restaurantForm.value;
        restaurant.vendor = this.authService.currentVendor;
        this.restAPI.createRestaurant(restaurant)
        .subscribe(
          (data: Restaurant) => {
            alert("Restaurant has been created!");
            let id: number = data.restaurantID;
            this.router.navigate(["/vendor/license-upload/" + id]);
          }
        );
      }
    }
    

}
