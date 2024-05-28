import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_CONFIG } from '../app.config';
import { TokenService } from '../autenticacao/token.service';
import { tap } from 'rxjs/operators';
import { LoginModel } from './login.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient, private tokenService: TokenService) { }

  efetuarLogin(loginModel: LoginModel): Observable<any> {
    const loginUrl = `${API_CONFIG.baseUrl}/login`;
    return this.http.post<any>(loginUrl, loginModel).pipe(
      tap(response => {
        this.tokenService.armazenarToken(response.token);
      })
    );
  }

}


