import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.router.events.subscribe((val) => {
      switch (this.router.url) {
        case "/public":
          this.setNavState(navStates.public);
          break;
        case "/vendor":
          if (localStorage.getItem("vendorToken") != null) {
            this.setNavState(navStates.vendorLoggedIn);
          }
          else {
            this.setNavState(navStates.vendor);
          }
          break;
        case "/home":
          this.setNavState(navStates.home);
      }
    }
    );
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
  home = "home",
  public = "public",
  vendor = "vendor",
  vendorLoggedIn = "vendorLoggedIn",
}