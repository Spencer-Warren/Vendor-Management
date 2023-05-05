import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from '../models/vendor';
import { Restaurant } from '../models/restaurant';
import { Dish } from '../models/dish';

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
  };

  httpOptionsFile = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE'
    })
  };


  get vednorID(): any {
    return sessionStorage.getItem('vendorId');
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

  deleteRestaurant(id: Number): Observable<any> {
    return this.http.delete(this.url + "/restaurant/" + id, this.httpOptions);
  }

  getRestaurant(id: Number): Observable<any> {
    return this.http.get(this.url + "/restaurant/" + this.vednorID + "/" + id, this.httpOptions);
  }

  updateRestaurant(restaurant: Restaurant): Observable<any> {
    return this.http.put(this.url + "/restaurant", restaurant, this.httpOptions);
  }



  uploadLicense(license: any, id: string): Observable<any> {
    return this.http.post(this.url + "/license/" + id, license, this.httpOptionsFile);
  }

  getLicense(id: string): Observable<any> {
    return this.http.get(this.url + "/license/" + id, { observe: 'response', responseType: 'blob'});
  }


  getDishes(restaurantID: number): Observable<any> {
    return this.http.get(this.url + "/dish/" + restaurantID, this.httpOptions);
  }

  createDish(dish: Dish): Observable<any> {
    return this.http.post(this.url + "/dish", dish, this.httpOptions);
  }

  deleteDish(id: Number): Observable<any> {
    return this.http.delete(this.url + "/dish/" + id, this.httpOptions);
  }

  updateDish(dish: Dish): Observable<any> {
    return this.http.put(this.url + "/dish", dish, this.httpOptions);
  }
  
}
