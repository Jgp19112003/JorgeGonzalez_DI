import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VehiculosDataService } from 'src/app/services/vehiculos-data.service';
import { vehiculo } from 'src/app/utils/vehiculo';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css']
})
export class BuscadorComponent {
  vehiculos: vehiculo[] = []
  mostrar = false
  constructor(
    private gestorRutas: Router,
    private servicio: VehiculosDataService
  ) {}

    datosFiltro(marca: string, cv: any){
      this.mostrar = true
      this.vehiculos =  this.servicio.getVehiculosBuscador(marca,cv)
    }
}
