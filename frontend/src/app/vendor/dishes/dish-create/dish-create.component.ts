import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-dish-create',
  templateUrl: './dish-create.component.html',
  styleUrls: ['./dish-create.component.css']
})
export class DishCreateComponent {
  dishForm!: FormGroup;
  
    constructor(private restAPI: RESTAPIService, private router: Router) { }
  
    ngOnInit(): void {
      this.dishForm = new FormBuilder().group({
        dishName: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        dishDescription: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        dishPrice: new FormControl <number> (0, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        dishCategory: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
        dishType: new FormControl <string> ('', [Validators.required, Validators.minLength(3), Validators.maxLength(50)])
        });
    }

    onSubmit() {
      if (this.dishForm.valid) {
        let dish = this.dishForm.value;
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
