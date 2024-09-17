import { Component } from '@angular/core';

@Component({
  selector: 'app-active-friends',
  templateUrl: './active-friends.component.html',
  styleUrl: './active-friends.component.scss'
})
export class ActiveFriendsComponent {
  friends = [
    { name: 'Charlie', image: 'assets/burger.jpg' },
    { name: 'Dave', image: 'assets/burger.jpg' },
    // Add more friends as needed
  ];
}
