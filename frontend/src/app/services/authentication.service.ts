import { Injectable } from '@angular/core';
import { RESTAPIService } from './restapi.service';
import { Vendor } from '../classes/vendor';
import { AppComponent } from '../app.component';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  SESSION_USERNAME_KEY = 'authenticatedUser';

  private user!: Vendor;
  private userDetail!: Vendor;

  constructor(private restapi: RESTAPIService) { }

  authenticate(vendor: Vendor) {
    return this.restapi.loginUser(vendor, { headers: { authorization: this.createAuthenticationToken(vendor.vendorUsername, vendor.vendorPassword) } });
  }

  success(vendor: Vendor) {
    console.log(vendor);
    this.userDetail = vendor;
    sessionStorage.setItem(this.SESSION_USERNAME_KEY, vendor.vendorUsername);
  }

  get userValue(): Vendor {
    return this.user;
  }

  get userDetailValue(): Vendor {
    return this.userDetail;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.SESSION_USERNAME_KEY);
    return !(user === null);
  }

  logout() {
    sessionStorage.removeItem(this.SESSION_USERNAME_KEY);
    this.user = new Vendor(0, "", "", "", "");
  }

  createAuthenticationToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password);
  }
}
