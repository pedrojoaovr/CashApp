import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GastosComponent } from './lista-gastos.component';


describe('ListaGastosComponent', () => {
  let component: GastosComponent;
  let fixture: ComponentFixture<GastosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GastosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GastosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});