import { Component, OnInit } from '@angular/core';
import { ListaGastosModel } from './lista-gastos.model';
import { ListaGastosService } from './lista-gastos.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-gastos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-gastos.component.html',
  styleUrl: './lista-gastos.component.scss'
})
export class GastosComponent implements OnInit {
  listaDeGastos: ListaGastosModel[] = [];

  constructor(private listaGastosService: ListaGastosService) { }

  ngOnInit(): void {
    this.obterListaDeGastos();
  }

  obterListaDeGastos() {
    this.listaGastosService.listaGastos().subscribe({
      next: (data: any) => {
        this.listaDeGastos = data.content;
      },
      error: (error: any) => {
        console.log('Erro ao obter lista de gastos:', error);
      }
    });
  }
}