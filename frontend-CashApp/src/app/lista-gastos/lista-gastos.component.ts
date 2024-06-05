import { Component, computed, inject, input, signal } from '@angular/core';
import { ListaGastosModel } from './lista-gastos.model';
import { ListaGastosService } from './lista-gastos.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista-gastos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './lista-gastos.component.html',
  styleUrls: ['./lista-gastos.component.scss']
})
export class GastosComponent {
  listGastoService = inject(ListaGastosService);

  lista = this.listGastoService.gastos;
  listFilter = signal('');

  filterCriteria = input({
    transform: (value: string) => value.toLocaleLowerCase(),
    alias: 'listCriteria'
  });

  filteredGastos = computed(() =>
    this.lista().filter(s => s.descricao.toLowerCase().includes(this.listFilter().toLowerCase()))
  );
}
