import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ActiveFriendsComponent } from './component/active-friends/active-friends.component';
import { PostFeedComponent } from './component/post-feed/post-feed.component';
import { TopFoodListComponent } from './component/top-food-list/top-food-list.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { FormsModule } from '@angular/forms';
import { provideHttpClient, withInterceptors, withInterceptorsFromDi } from '@angular/common/http';
import { authInterceptor } from './service/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    ActiveFriendsComponent,
    PostFeedComponent,
    TopFoodListComponent,
    HomePageComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    // {
        //   provide: HTTP_INTERCEPTORS,useValue: authInterceptor, multi: true
        // }
        provideHttpClient(withInterceptors([authInterceptor])),
        provideHttpClient(withInterceptorsFromDi())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
