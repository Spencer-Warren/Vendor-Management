import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  constructor(private router: Router, private authservice: AuthenticationService) { }

  ngOnInit(): void {
    this.router.events.subscribe((val) => {
      if (this.router.url.match(/\/vendor\/.*/)) {
        if (sessionStorage.getItem("vendorId") != null) {
          this.setNavState(navStates.vendorLoggedIn);
        }
        else {
          this.setNavState(navStates.vendor);
        }
      }
      else if (this.router.url == "/public") {
        this.setNavState(navStates.public);
      }

    }
    );
  }

  logout() {
    this.authservice.logout();
  }



  currentNavState: navStates = navStates.home;
  navStates = navStates;
  observableNavState: BehaviorSubject<navStates> = new BehaviorSubject<navStates>(this.currentNavState);

  setNavState(state: navStates) {
    this.currentNavState = state;
    this.observableNavState.next(this.currentNavState);
  }

}

export enum navStates {
  home,
  public,
  vendor ,
  vendorLoggedIn,
}