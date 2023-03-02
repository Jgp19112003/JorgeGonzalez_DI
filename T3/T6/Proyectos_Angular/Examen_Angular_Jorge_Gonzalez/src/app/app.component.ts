import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VehiculosDataService } from './services/vehiculos-data.service';
import { vehiculo } from './utils/vehiculo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Examen_Angular_Jorge_Gonzalez';

  constructor(
    private gestorRutas: Router,
    private servicio: VehiculosDataService
  ) {}

  navegarComponente(dato: number) {
    this.gestorRutas.navigate(['maincomponent', dato]);
  }

  tipoVehiculos(tipo: string) {
    console.log(tipo);
    this.servicio.tipo_vehiculo = tipo;
  }
}
