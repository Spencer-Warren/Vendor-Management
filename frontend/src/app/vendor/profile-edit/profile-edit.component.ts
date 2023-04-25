import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {
  name: string = sessionStorage.getItem("vendorName")!;
  email: string = sessionStorage.getItem("vendorEmail")!;
  username: string = sessionStorage.getItem("vendorUsername")!;

  profileForm!: FormGroup;

  constructor(private restAPIService: RESTAPIService, private router: Router, private authenticationService: AuthenticationService) {
  }
  ngOnInit(): void {
    this.profileForm = new FormBuilder().group({
      vendorName: new FormControl <string> (this.name, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      vendorEmail: new FormControl <string> (this.email, [Validators.required, Validators.email]),
      vendorUsername: new FormControl <string> (this.username, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
    });
  }

  onSubmit() {
    if (this.profileForm.valid) {
      let vendor = this.profileForm.value;
      
      if (vendor.vendorName == this.name && vendor.vendorEmail == this.email && vendor.vendorUsername == this.username) {
        alert("No changes were made");
        this.router.navigate(['vendor/profile']);
        return;
      }
      
      vendor.vendorId = Number(sessionStorage.getItem("vendorId"));
      this.restAPIService.updateVenor(vendor).subscribe(
        (response: any) => {
          alert("Profile updated successfully");
          this.authenticationService.update(vendor);
          if (vendor.username != this.username) {
            alert("You will be logged out to update your username");
            this.authenticationService.logout();
            return;
          }
          this.router.navigate(['vendor/profile']);
        }
      );
    }
  }
}
