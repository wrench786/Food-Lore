import { Component } from '@angular/core';

interface Food {
  name: string;
  imageUrl: string;
  likes: number;
  dislikes: number;
}

@Component({
  selector: 'app-top-food-list',
  templateUrl: './top-food-list.component.html',
  styleUrl: './top-food-list.component.scss'
})
export class TopFoodListComponent {
  foods: Food[] = [
    { name: 'Pizza', imageUrl: 'assets/pizza.jpg', likes: 120, dislikes: 30 },
    { name: 'Burger', imageUrl: 'assets/burger.jpg', likes: 110, dislikes: 20 },
    { name: 'Sushi', imageUrl: 'assets/sushi.jpg', likes: 100, dislikes: 15 },
    { name: 'Pasta', imageUrl: 'assets/pasta.jpg', likes: 90, dislikes: 25 },
    { name: 'dosa', imageUrl: 'https://i.postimg.cc/wvWyGF7r/dosa.jpg', likes: 85, dislikes: 10 },
    { name: 'Tacos', imageUrl: 'assets/tacos.jpg', likes: 80, dislikes: 12 },
    { name: 'Steak', imageUrl: 'assets/steak.jpg', likes: 75, dislikes: 20 },
    { name: 'Salad', imageUrl: 'assets/salad.jpg', likes: 70, dislikes: 18 },
    { name: 'Soup', imageUrl: 'assets/soup.jpg', likes: 65, dislikes: 22 },
    { name: 'Dumplings', imageUrl: 'assets/dumplings.jpg', likes: 60, dislikes: 30 },
  ];
}
