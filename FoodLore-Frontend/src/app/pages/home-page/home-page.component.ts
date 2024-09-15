import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.scss'
})
export class HomePageComponent{
  posts = [
    {
      id: 1,
      user: 'John Doe',
      time: '2 hours ago',
      content: 'This is the first post content. It is really amazing!',
      image: 'assets/burger.jpg'
    },
    {
      id: 2,
      user: 'Jane Smith',
      time: '5 hours ago',
      content: 'This is another post, and it has some really cool information.',
      image: 'assets/pizza.jpg'
    },
    {
      id: 3,
      user: 'Alice Brown',
      time: '1 day ago',
      content: 'Here’s a great post about nature and the environment!',
      image: 'assets/singara.jpg'
    }
  ];

}
