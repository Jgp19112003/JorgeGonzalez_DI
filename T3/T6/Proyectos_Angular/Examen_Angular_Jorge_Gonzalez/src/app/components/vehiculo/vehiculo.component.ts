import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { VehiculosDataService } from 'src/app/services/vehiculos-data.service';
import { vehiculo } from 'src/app/utils/vehiculo';

@Component({
  selector: 'app-vehiculo',
  templateUrl: './vehiculo.component.html',
  styleUrls: ['./vehiculo.component.css'],
})
export class VehiculoComponent {
  vehiculos: vehiculo[] = [];

  datoComunicado = '';
  tipo_vehiculo = '';

  constructor(
    private gestorRutas: ActivatedRoute,
    private servicio: VehiculosDataService
  ) {
    gestorRutas.params.subscribe((param: Params) => {
      this.datoComunicado = param['id'];
      console.log(param['id']);
      this.vehiculos = servicio.getVehiculosFiltrados();

      this.vehiculos.forEach((element) => {
        this.tipo_vehiculo = element.tipo;
      });
    });
  }
}
