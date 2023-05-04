import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent }       from './home/home.component';
import { PublicComponent }     from './home/public/public.component';
import { RestaurantComponent } from './home/restaurant/restaurant.component';

import { VendorComponent }           from './vendor/vendor.component';
import { LoginComponent }            from './vendor/login/login.component';
import { RegisterComponent }         from './vendor/register/register.component';
import { VendorHomeComponent }       from './vendor/home/vendor-home.component';

import { ProfileComponent }          from './vendor/profile/profile.component';
import { ProfileEditComponent }      from './vendor/profile/profile-edit/profile-edit.component';

import { VendorRestaurantComponent } from './vendor/restaurant/vendor-restaurant.component';
import { RestaurantCreateComponent } from './vendor/restaurant/restaurant-create/restaurant-create.component';
import { RestaurantEditComponent }   from './vendor/restaurant/restaurant-edit/restaurant-edit.component';


import { LicenseUploadComponent }    from './vendor/license/license-upload/license-upload.component';
import { LicenseViewComponent } from './vendor/license/license-view/license-view.component';
import { VendorDishesComponent } from './vendor/dishes/vendor-dishes/vendor-dishes.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home',       component: HomeComponent},

  { path: 'vendor',            component: VendorComponent },
  { path: 'vendor/home',       component: VendorHomeComponent},
  { path: 'vendor/login',      component: LoginComponent},
  { path: 'vendor/register',   component: RegisterComponent},

  { path: 'vendor/license-upload/:id', component: LicenseUploadComponent},
  { path: 'vendor/license-view/:id',   component: LicenseViewComponent},

  { path: 'vendor/profile',      component: ProfileComponent},
  { path: 'vendor/profile/edit', component: ProfileEditComponent },
  
  { path: 'vendor/restaurants',          component: VendorRestaurantComponent},
  { path: 'vendor/restaurants/create',   component: RestaurantCreateComponent},
  { path: 'vendor/restaurants/edit/:id', component: RestaurantEditComponent},

  { path: 'vendor/restaurants/:id/dishes', component: VendorDishesComponent},

  { path: 'public',     component: PublicComponent},
  { path: 'restaurant', component: RestaurantComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
