import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NavComponent } from './nav/nav.component';

import { HomeComponent } from './home/home.component';
import { PublicComponent } from './home/public/public.component';
import { RestaurantComponent } from './home/restaurant/restaurant.component';

import { VendorComponent } from './vendor/vendor.component';
import { LoginComponent } from './vendor/login/login.component';
import { RegisterComponent } from './vendor/register/register.component';
import { ProfileComponent } from './vendor/profile/profile.component';
import { VendorRestaurantComponent } from './vendor/restaurant/vendor-restaurant.component';
import { VendorHomeComponent } from './vendor/home/vendor-home.component';
import { ProfileEditComponent } from './vendor/profile/profile-edit/profile-edit.component';
import { RestaurantCreateComponent } from './vendor/restaurant/restaurant-create/restaurant-create.component';
import { RestaurantEditComponent } from './vendor/restaurant/restaurant-edit/restaurant-edit.component';

import { LicenseUploadComponent } from './vendor/license/license-upload/license-upload.component';
import { LicenseViewComponent } from './vendor/license/license-view/license-view.component';


import { ErrorInterceptor } from './services/errorInterceptor.service';
import { BasicAuthInterceptor } from './services/basicAuthInterceptor.service';
import { VendorDishesComponent } from './vendor/dishes/vendor-dishes/vendor-dishes.component';
import { DishCreateComponent } from './vendor/dishes/dish-create/dish-create.component';


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
    ProfileComponent,
    VendorRestaurantComponent,
    VendorHomeComponent,
    ProfileEditComponent,
    RestaurantCreateComponent,
    RestaurantEditComponent,
    LicenseUploadComponent,
    LicenseViewComponent,
    VendorDishesComponent,
    DishCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
    ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true},
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
