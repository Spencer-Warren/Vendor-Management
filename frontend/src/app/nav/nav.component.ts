import { Component } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  constructor() { }

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
  vendor,
  vendorLoggedIn
}