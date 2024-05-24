import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginService } from './login-service.service';
import { LoginModel } from './login.model';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
  providers:[LoginService]
})
export class LoginComponent {

  entity: LoginModel = { email: '', senha: '' };
  
  constructor(
    private service:LoginService,
    private router: Router
  ) { }

  login() {
    this.service.efetuarLogin(this.entity).subscribe({
      next: (response: any) => {
        console.log('Login efetuado com sucesso!');
        console.log('Token JWT:', response.token); 
      },
      error: (error: any) => {
        console.error('Erro ao efetuar login:', error);
      }
    });
  }

}
