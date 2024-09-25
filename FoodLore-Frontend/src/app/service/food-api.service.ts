import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodApiService {
  private baseApiUrl = 'http://localhost:8080/api/food';
  constructor(private httpClient: HttpClient) { }

  getTopTenFoodList(): Observable<any>{
    return this.httpClient.get(`${this.baseApiUrl}/top-ten-foods`);
  }
}