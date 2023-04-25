import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { Vendor } from 'src/app/classes/vendor';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  encryptedPassword: string = '';

  constructor(private app: AppComponent, private authService: AuthenticationService,private APISerivce: RESTAPIService, private router: Router) { }

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
      this.authService.authenticate(user).subscribe(
        (data: Vendor) => {
          if (data.vendorId == 0) {
            alert("Invalid Credentials");
            return;
          }
          else {
            this.authService.success(data);
            this.router.navigate(['vendor/profile']);
          }
        }
      )
    }
  }


  get username() {
    return this.loginForm.get('username');
  }

  get password() {
    return this.loginForm.get('password');
  }

}
