import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { TopFoodListComponent } from './component/top-food-list/top-food-list.component';
import { PostFeedComponent } from './component/post-feed/post-feed.component';
import { ActiveFriendsComponent } from './component/active-friends/active-friends.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    TopFoodListComponent,
    PostFeedComponent,
    ActiveFriendsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
