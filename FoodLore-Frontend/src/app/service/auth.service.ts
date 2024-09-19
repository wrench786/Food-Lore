import { Injectable } from '@angular/core';
import { User } from '../pages/login-page/login-page.component';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private tokenKey = 'authToken';
  private baseApiUrl = 'http://localhost:8080/api/auth/login';
  constructor(private httpClient: HttpClient) { }

  login(user:User): Observable<any>{
    console.log(user);
    return this.httpClient.post(this.baseApiUrl, user);
  }

  saveToken(token:string):void{
    localStorage.setItem(this.tokenKey,token);
  }
  
  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }
  
  logOut():void{
    localStorage.removeItem(this.tokenKey);
  }
}
