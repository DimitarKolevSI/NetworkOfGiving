import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CreateCharityComponent } from './create-charity/create-charity.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DetailCharityViewComponent } from './detail-charity-view/detail-charity-view.component';
import { MyProfilePageComponent } from './my-profile-page/my-profile-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SearchPageComponent } from './search-page/search-page.component';


const routes: Routes = [
    {
      path: 'login',
      component:LoginComponent
    },
    {
      path: 'register',
      component:RegisterComponent
    },
    {
      path: 'create_charity',
      component:CreateCharityComponent
    },
    {
      path: 'home',
      component:HomePageComponent
    },
    {
      path:'charity/:title',
      component:DetailCharityViewComponent
    },
    {
      path:'profile/:username',
      component:MyProfilePageComponent
    },
    {
      path:'error',
      component:PageNotFoundComponent
    },
    {
      path:'search/:key',
      component:SearchPageComponent
    },
    {
      path: '**',
      redirectTo:'/home',
      pathMatch: 'full'
    }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
