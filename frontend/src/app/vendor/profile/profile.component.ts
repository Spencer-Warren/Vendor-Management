import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  name: string = sessionStorage.getItem("vendorName")!;
  email: string = sessionStorage.getItem("vendorEmail")!;
  username: string = sessionStorage.getItem("vendorUsername")!;
  
  constructor(private authService:    AuthenticationService, private restAPIService: RESTAPIService, private router: Router) {
  }

  

  toEdit() {
    this.router.navigate(['vendor/profile/edit']);
  }

  toDelete() {
    const shouldDelete: Boolean  = confirm("Are you sure you want to delete your account?");
    if (shouldDelete) {
      this.restAPIService.deleteVendor(sessionStorage.getItem("vendorId")).subscribe((data: string) => {
        alert(data);
        this.authService.logout();
        
      });
    }
  }
}
