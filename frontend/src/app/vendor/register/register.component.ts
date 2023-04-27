import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Vendor } from 'src/app/models/vendor';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  registerForm!: FormGroup;
  encryptedPassword!: string;

  constructor(private fb: FormBuilder, private router: Router, private service: RESTAPIService) { }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      name: new FormControl <string> ('', [Validators.required, Validators.minLength(3)]),
      username: new FormControl <string> ('', [Validators.required, Validators.minLength(3)]),
      password: new FormControl <string> ('', [Validators.required, Validators.minLength(8)]),
      confirmPassword: new FormControl <string> ('', [Validators.required, Validators.minLength(8)]),
      email: new FormControl <string> ('', [Validators.required, Validators.email])
    });
  }


  onSubmit() {
    if (this.registerForm.valid && this.passwordMatch) {

      let user: Vendor = new Vendor(0, this.registerForm.get('name')?.value, this.registerForm.get('email')?.value, this.registerForm.get('username')?.value, this.registerForm.get('password')?.value);
      this.service.registerVendor(user).subscribe((data: any) => {
        this.success();
      });
    }
  }

  success() {
    alert("Registration successful! You can now log in.");
    this.registerForm.reset();
    this.router.navigate(['/vendor/login']);
  }

  get name(){
    return this.registerForm.get('name');
  }

  get email() {
    return this.registerForm.get('email');
  }

  get username() {
    return this.registerForm.get('username');
  }

  get password() {
    return this.registerForm.get('password');
  }
  
  get confirmPassword() {
    return this.registerForm.get('confirmPassword');
  }

  get passwordMatch() {
    return this.registerForm.get('password')?.value === this.registerForm.get('confirmPassword')?.value;
  }

}
