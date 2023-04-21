import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import { PublicComponent } from './home/public/public.component';
import { VendorComponent } from './vendor/vendor.component';
import { LoginComponent } from './vendor/login/login.component';
import { RegisterComponent } from './vendor/register/register.component';
import { RestaurantComponent } from './home/restaurant/restaurant.component';
import { DishComponent } from './vendor/dish/dish.component';
import { ProfileComponent } from './vendor/profile/profile.component';
import { VendorRestaurantComponent } from './vendor/restaurant/vendor-restaurant.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    PublicComponent,
    VendorComponent,
    LoginComponent,
    RegisterComponent,
    RestaurantComponent,
    DishComponent,
    ProfileComponent,
    VendorRestaurantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
