import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { GastosComponent } from './lista-gastos/lista-gastos.component';


export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'gastos', component: GastosComponent },  
  ];
  
@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRouteModule {
}

