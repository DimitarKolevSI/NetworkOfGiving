import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClarityModule, ClrFormsModule } from '@clr/angular';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CreateCharityComponent } from './create-charity/create-charity.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CharityViewComponent } from './charity-view/charity-view.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DetailCharityViewComponent } from './detail-charity-view/detail-charity-view.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MyProfilePageComponent } from './my-profile-page/my-profile-page.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { CutPipePipe } from './cut-pipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    CreateCharityComponent,
    PageNotFoundComponent,
    CharityViewComponent,
    HomePageComponent,
    DetailCharityViewComponent,
    MyProfilePageComponent,
    SearchPageComponent,
    CutPipePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClarityModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
