import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Dish } from 'src/app/models/dish';
import { RESTAPIService } from 'src/app/services/restapi.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-dish-create',
  templateUrl: './dish-create.component.html',
  styleUrls: ['./dish-create.component.css']
})
export class DishCreateComponent {
  dishForm!: FormGroup;
  
    constructor(private restAPI: RESTAPIService, private router: Router, private restaurantService: RestaurantsService) { }
  
    ngOnInit(): void {
      if (this.restaurantService.getCurrentRestaurant() == null) {
        this.router.navigate(['/vendor/restaurants']);
      }
      this.dishForm = new FormBuilder().group({
        name: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        description: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(1024)]),
        price: new FormControl <number> (0, [Validators.required]),
        category: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        });
    }

    onSubmit() {
      if (this.dishForm.valid) {
        let dish: Dish = new Dish(0, this.dishForm.value.name, this.dishForm.value.description, this.dishForm.value.price, this.dishForm.value.category, this.restaurantService.getCurrentRestaurant());
        this.restAPI.createDish(dish)
        .subscribe(
          (data: any) => {
            alert("Dish has been created!");
            this.router.navigate([this.router.url.split("/").slice(0, -1).join("/")]);
          }
        );
      }
    }
}
