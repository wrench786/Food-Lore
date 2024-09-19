import { Component } from '@angular/core';
import { AuthApiService } from '../../service/auth-api.service';
import { Router } from '@angular/router';

export interface User{
  username:string,
  password:string
}

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.scss'
})
export class LoginPageComponent {
  user : User = {username:'', password:''};

  constructor(
    private authApiService:AuthApiService,
    private router: Router
  ){}

  userLogin(){
    console.log(this.user);
    this.authApiService.login(this.user).subscribe({
      next: (data) => {
        console.log("Login Success");
        console.log(data);
        if(data.jwtToken){
          this.authApiService.saveToken(data.jwtToken);
          this.router.navigate(['/home']);
        }
        else{
          console.log('Login failed: No token received');
          alert('Login failed: Invalid credentials or no token returned');
        }
      },
      error: (data) => {
        // Handle HTTP errors or server issues
        console.log('Login request failed:', data);
        alert('Login request failed: Please try again later');
      }
    });
  }
}
