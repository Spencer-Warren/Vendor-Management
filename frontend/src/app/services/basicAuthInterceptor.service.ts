import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';


@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        const isLoggedIn = this.authenticationService.isUserLoggedIn();
        if (isLoggedIn) {
            request = request.clone({
                setHeaders: { 
                    Authorization: '' + sessionStorage.getItem("token")
                }
            });
        }
        return next.handle(request);
    }
}