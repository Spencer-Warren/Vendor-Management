import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './home/home.component';
import { PublicComponent } from './public/public.component';
import { VendorComponent } from './vendor/vendor.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { DishComponent } from './dish/dish.component';
import { ProfileComponent } from './profile/profile.component';
import { VendorRestaurantComponent } from './vendor-restaurant/vendor-restaurant.component';

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
