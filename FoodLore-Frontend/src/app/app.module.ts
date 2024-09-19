import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { TopFoodListComponent } from './component/top-food-list/top-food-list.component';
import { PostFeedComponent } from './component/post-feed/post-feed.component';
import { ActiveFriendsComponent } from './component/active-friends/active-friends.component';
import { HTTP_INTERCEPTORS, HttpClientModule, provideHttpClient, withInterceptors } from '@angular/common/http';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { FormsModule } from '@angular/forms';
import { authInterceptor } from './service/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    TopFoodListComponent,
    PostFeedComponent,
    ActiveFriendsComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    // {
    //   provide: HTTP_INTERCEPTORS,useValue: authInterceptor, multi: true
    // }
    provideHttpClient(withInterceptors([authInterceptor]))
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
