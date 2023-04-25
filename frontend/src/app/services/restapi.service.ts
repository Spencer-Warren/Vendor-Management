import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from '../classes/vendor';
import { loginVendor } from '../classes/loginVendor';

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

  registerUser(user: Vendor): Observable<any> {
    return this.http.post(this.url + "/register", user, this.httpOptions);
  }

  getUser(username: any) {
    return this.http.get(this.url + "/vendor/" + username, this.httpOptions);
  }

  loginUser(user: Vendor, httpOptions: any): Observable<any> {
    return this.http.post(this.url + "/login", user, httpOptions);
  }
}
