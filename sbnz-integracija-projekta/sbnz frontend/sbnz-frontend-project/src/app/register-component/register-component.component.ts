import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent {
  name: string = '';
  surname: string = '';
  gmail: string = '';
  password: string = '';

  constructor(private router: Router, private http: HttpClient) {}

  onRegister() {
    const registerData = {
      name: this.name,
      surname: this.surname,
      gmail: this.gmail,
      password: this.password
    };

    this.http.post('http://localhost:8080/register', registerData).subscribe(
      (response) => {
        console.log('Registration successful', response);
        // Navigate to login page after successful registration
        this.router.navigate(['/login']);
      },
      (error) => {
        console.error('Registration failed', error);
      }
    );
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}
