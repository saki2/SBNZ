import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent {
  gmail: string = '';
  password: string = '';

  constructor(private router: Router, private http: HttpClient) {}

  onLogin() {
    const loginData = {
      gmail: this.gmail,
      password: this.password
    };

    this.http.post('http://localhost:8080/login', loginData).subscribe(
      (response) => {
        console.log('Login successful', response);
        // Navigate to another component upon successful login
        this.router.navigate(['/alarm-overview']);
      },
      (error) => {
        console.error('Login failed', error);
      }
    );
  }

  goToRegistration() {
    this.router.navigate(['/register']);
  }
}
