import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { loginVendor } from 'src/app/classes/loginVendor';
import { Vendor } from 'src/app/classes/vendor';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  encryptedPassword: string = '';

  constructor(private app: AppComponent, private service: RESTAPIService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl<string>('', [Validators.required, Validators.minLength(3)]),
      password: new FormControl<string>('', [Validators.required, Validators.minLength(8)]),
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      let user = new Vendor(0,"","",this.loginForm.value.username, this.loginForm.value.password);
      console.log(user);
      this.service.loginUser(user).subscribe( 
        // isValid => {
        //   if (isValid) {
        //     this.getUser();
        //     // sessionStorage.setItem('token', this.loginForm.value.username + " : " + this.loginForm.value.password);
        //   }
        //   else {
        //     console.log("Invalid login");
        //   }
        // }
        (data: any) => {
          console.log(data);
          if (data) {
            this.getUser();
          }
          else {
            console.log("Invalid login");
          }
        }
        );

    }
  }

  getUser() {
    this.service.getUser(this.loginForm.value.username).subscribe((data: any) => {
      this.app.login(data);
      this.router.navigate(['/tasks']);
    });
  }

  get username() {
    return this.loginForm.get('username');
  }

  get password() {
    return this.loginForm.get('password');
  }

}
