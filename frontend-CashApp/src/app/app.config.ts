import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import {HTTP_INTERCEPTORS, provideHttpClient, withInterceptors, withInterceptorsFromDi} from '@angular/common/http';
import { routes } from './app.routes';
import { AuthInterceptor } from './autenticacao/auth.interceptor.service';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }), 
    provideRouter(routes),
    provideHttpClient(),
  {provide: HTTP_INTERCEPTORS, 
    useClass: AuthInterceptor, 
    multi: true},
    provideHttpClient(withInterceptorsFromDi()) ]

  };


export const API_CONFIG = {
  baseUrl: 'http://localhost:8090'
  
};

