import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from '../classes/vendor';
import { Restaurant } from '../classes/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RESTAPIService {

  url: string = "http://localhost:5000/api";

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE'
    })
  }

  registerVendor(user: Vendor): Observable<any> {
    return this.http.post(this.url + "/register", user, this.httpOptions);
  }

  getVendor(username: any): Observable<any> {
    return this.http.get(this.url + "/vendor/" + username, this.httpOptions);
  }

  loginVendor(user: Vendor, httpOptions: any): Observable<any> {
    return this.http.post(this.url + "/login", user, httpOptions);
  }

  updateVenor(user: Vendor): Observable<any> {
    return this.http.put(this.url + "/vendor", user, this.httpOptions);
  }

  deleteVendor(id: any): Observable<any> {
    return this.http.delete(this.url + "/delete/" + id, this.httpOptions);
  }

  getAllRestaurants(id: any): Observable<any> {
    return this.http.get(this.url + "/restaurant/" + id, this.httpOptions);
  }

  createRestaurant(restaurant: Restaurant): Observable<any> {
    return this.http.post(this.url + "/restaurant", restaurant, this.httpOptions);
  }

  deleteRestaurant(id: Number){
    return this.http.delete(this.url + "/restaurant/" + id, this.httpOptions);
  }

}
