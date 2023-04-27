import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { VendorComponent } from './vendor/vendor.component';
import { LoginComponent } from './vendor/login/login.component';
import { RegisterComponent } from './vendor/register/register.component';
import { ProfileComponent } from './vendor/profile/profile.component';
import { PublicComponent } from './home/public/public.component';
import { RestaurantComponent } from './home/restaurant/restaurant.component';
import { DishComponent } from './vendor/dish/dish.component';
import { VendorRestaurantComponent } from './vendor/restaurant/vendor-restaurant.component';
import { VendorHomeComponent } from './vendor/home/vendor-home.component';
import { ProfileEditComponent } from './vendor/profile-edit/profile-edit.component';
import { RestaurantCreateComponent } from './vendor/restaurant/restaurant-create/restaurant-create.component';
import { RestaurantEditComponent } from './vendor/restaurant/restaurant-edit/restaurant-edit.component';
import { LicenseUploadComponent } from './vendor/license-upload/license-upload.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home',       component: HomeComponent},

  { path: 'vendor',     component: VendorComponent },
  { path: 'vendor/home',       component: VendorHomeComponent},
  { path: 'vendor/login',      component: LoginComponent},
  { path: 'vendor/register',   component: RegisterComponent},

  { path: 'vendor/license-upload/:id', component: LicenseUploadComponent},

  { path: 'vendor/profile',    component: ProfileComponent},
  { path: 'vendor/profile/edit', component: ProfileEditComponent },
  
  { path: 'vendor/restaurants', component: VendorRestaurantComponent},
  { path: 'vendor/restaurants/create', component: RestaurantCreateComponent},
  { path: 'vendor/restaurants/edit/:id', component: RestaurantEditComponent},

  { path: 'public',     component: PublicComponent},
  { path: 'restaurant', component: RestaurantComponent},
  { path: 'dish',       component: DishComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
