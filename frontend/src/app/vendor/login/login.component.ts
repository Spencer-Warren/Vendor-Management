import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { Vendor } from 'src/app/models/vendor';
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
      let loginUser = new Vendor(0,"","",this.loginForm.value.username, this.loginForm.value.password);
      this.authService.authenticate(loginUser).subscribe(
        (data: any) => {
          if (data.vendorId != 0) {
            let newVendor: Vendor = new Vendor(data.vendorId, data.vendorName, data.vendorEmail, data.username, loginUser.vendorPassword);
            this.authService.success(newVendor);
            this.router.navigate(['vendor/home']);
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
