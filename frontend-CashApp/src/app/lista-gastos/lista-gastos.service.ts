import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TokenService } from '../autenticacao/token.service';
import { ListaGastosModel } from './lista-gastos.model';
import { API_CONFIG } from '../app.config';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListaGastosService {

  constructor(private http: HttpClient, private tokenService: TokenService) {}

  listaGastos(): Observable<ListaGastosModel[]> {
    const listaUrl = `${API_CONFIG.baseUrl}/gastos/meus-gastos`;
    return this.http.get<ListaGastosModel[]>(listaUrl);
  }
}
