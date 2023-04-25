import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import { Vendor } from '../classes/vendor';


@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const user: Vendor = this.authenticationService.userValue;
        const isLoggedIn = this.authenticationService.isUserLoggedIn();
        if (isLoggedIn) {
            request = request.clone({
                setHeaders: { 
                    Authorization: `Basic ${user.vendorUsername}:${user.vendorPassword}`
                }
            });
        }
        return next.handle(request);
    }
}