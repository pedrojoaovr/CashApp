import { TestBed } from '@angular/core/testing';
import { ListaGastosService } from './lista-gastos.service';


describe('ListaGastosService', () => {
  let service: ListaGastosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaGastosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
