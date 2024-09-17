import { Component } from '@angular/core';

@Component({
  selector: 'app-post-feed',
  templateUrl: './post-feed.component.html',
  styleUrl: './post-feed.component.scss'
})
export class PostFeedComponent {
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
  createPost() {
    const newPostContent = prompt('What’s on your mind?');
    if (newPostContent) {
      this.posts.push({
        id:4,
        user: 'You', 
        time:'5 days ago',
        content: newPostContent,
        image: 'assets/singara.jpg' 
      });
    }
  }
}
