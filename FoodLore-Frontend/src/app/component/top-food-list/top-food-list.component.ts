import { Component, OnInit } from '@angular/core';
import { FoodApiService } from '../../service/food-api.service';

interface Food {
  id: number;
  name: string;
  description: string;
  likes: number;
  dislikes: number;
  image_url: string;
}

@Component({
  selector: 'app-top-food-list',
  templateUrl: './top-food-list.component.html',
  styleUrl: './top-food-list.component.scss'
})
export class TopFoodListComponent implements OnInit {
  foods: Food[] = [];
  error: string | undefined;
  constructor(
    private foodApiService: FoodApiService
  ){}

  ngOnInit(): void {
    this.foodApiService.getTopTenFoodList().subscribe({
      next: (data) => {
        this.foods = data;
        console.log(data);
      },
      error: (data) => {
        this.error = data;
        console.log(data);
      }
    });
  }
}
