import { Injectable } from '@angular/core';
import { RESTAPIService } from './restapi.service';
import { Vendor } from '../models/vendor';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {


  constructor(private restapi: RESTAPIService, private router: Router) { }

  authenticate(vendor: Vendor) {
    return this.restapi.loginVendor(vendor, { headers: { authorization: this.createAuthenticationToken(vendor.vendorUsername, vendor.vendorPassword) } });
  }

  success(vendor: Vendor) {
    sessionStorage.setItem("vendorId", vendor.vendorId.toString());
    sessionStorage.setItem("vendorName", vendor.vendorName);
    sessionStorage.setItem("vendorEmail", vendor.vendorEmail);
    sessionStorage.setItem("vendorUsername", vendor.vendorUsername);
    sessionStorage.setItem("token", this.createAuthenticationToken(vendor.vendorUsername, vendor.vendorPassword));
  }

  update (vendor: Vendor) {
    sessionStorage.setItem("vendorName", vendor.vendorName);
    sessionStorage.setItem("vendorEmail", vendor.vendorEmail);
    sessionStorage.setItem("vendorUsername", vendor.vendorUsername);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("vendorUsername");
    return !(user === null);
  }

  logout() {
    alert("You have been logged out");
    sessionStorage.removeItem("vendorId");
    sessionStorage.removeItem("vendorName");
    sessionStorage.removeItem("vendorEmail");
    sessionStorage.removeItem("vendorUsername");
    sessionStorage.removeItem("token");
    
    this.router.navigate(['']);
  }

  createAuthenticationToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password);
  }

  get currentVendor(): Vendor {
    let id: Number = Number(sessionStorage.getItem("vendorId"));
    return new Vendor(id, "","","","");
  }
}
