import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { VendorComponent } from './vendor/vendor.component';
import { LoginComponent } from './vendor/login/login.component';
import { RegisterComponent } from './vendor/register/register.component';
import { ProfileComponent } from './vendor/profile/profile.component';
import { PublicComponent } from './public/public.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { DishComponent } from './vendor/dish/dish.component';
import { VendorRestaurantComponent } from './vendor/restaurant/vendor-restaurant.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home',       component: HomeComponent},

  { path: 'vendor',     component: VendorComponent },
  { path: 'vendor/login',      component: LoginComponent},
  { path: 'vendor/register',   component: RegisterComponent},
  { path: 'vendor/profile',    component: ProfileComponent},
  { path: 'vendor/restaurants', component: VendorRestaurantComponent},

  { path: 'public',     component: PublicComponent},
  { path: 'restaurant', component: RestaurantComponent},
  { path: 'dish',       component: DishComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
