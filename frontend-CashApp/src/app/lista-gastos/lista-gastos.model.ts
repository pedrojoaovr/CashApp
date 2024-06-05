export interface ListaGastosModel {
  id: number;
  usuario: string;
  valor: number;
  descricao: string;
  data: Date;
}

export const GASTOS: ListaGastosModel[] = [
  { descricao: 'popcorn', valor: 2.0, id: 1, data: new Date('2004-03-01'), usuario: 'jpvr' },
  { descricao: 'peanuts', valor: 3.0, id: 2, data: new Date('2004-03-01'), usuario: 'jpvr' },
  { descricao: 'mixed nuts', valor: 5.0, id: 3, data: new Date('2004-03-01'), usuario: 'jpvr' },
   { descricao: 'popcorn', valor: 2.0, id: 1, data: new Date('2004-03-01'), usuario: 'jpvr' },
];
