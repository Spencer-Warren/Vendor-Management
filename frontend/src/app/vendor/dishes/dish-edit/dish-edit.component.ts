import { HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Dish } from 'src/app/models/dish';
import { RESTAPIService } from 'src/app/services/restapi.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-dish-edit',
  templateUrl: './dish-edit.component.html',
  styleUrls: ['./dish-edit.component.css']
})
export class DishEditComponent {
  dishForm!: FormGroup;
  currentDish!: Dish;
  
  constructor(private restAPI: RESTAPIService, private router: Router, private restaurantService: RestaurantsService) { }

  ngOnInit(): void {
    if (this.restaurantService.getCurrentDish() == null) {
      this.router.navigate(['/vendor/restaurants']);
    }
    else {
      this.currentDish = this.restaurantService.getCurrentDish();
    }
    this.dishForm = new FormBuilder().group({
      name: new FormControl <string> (this.currentDish.dishName, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      description: new FormControl <string> (this.currentDish.dishDescription, [Validators.required, Validators.minLength(3), Validators.maxLength(1024)]),
      price: new FormControl <number> (this.currentDish.dishPrice, [Validators.required]),
      category: new FormControl <string> (this.currentDish.dishCategory, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
    });
  }

  onSubmit() {
    if (this.dishForm.valid) {
      let dish: Dish = new Dish(
        this.currentDish.dishID, 
        this.dishForm.value.name, 
        this.dishForm.value.description, 
        this.dishForm.value.price, 
        this.dishForm.value.category, 
        this.currentDish.restaurant
        );
      this.restAPI.updateDish(dish)
      .subscribe(
        (data: any) => {
          alert("Dish has been updated!");
          this.router.navigate(['/vendor/restaurants/dishes']);
        }
      );
    }
  }
}
