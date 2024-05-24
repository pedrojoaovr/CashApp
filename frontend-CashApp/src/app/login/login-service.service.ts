import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginModel } from './login.model';
import { Observable } from 'rxjs';
import { API_CONFIG } from '../app.config';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  efetuarLogin(loginModel:LoginModel): Observable<any> {
    const loginUrl = `${API_CONFIG.baseUrl}/login`;
    return this.http.post<any>(loginUrl, loginModel);
  }
}


