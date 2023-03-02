import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuscadorComponent } from './components/buscador/buscador.component';
import { VehiculoComponent } from './components/vehiculo/vehiculo.component';

const routes: Routes = [
  { path: 'vehiculo/:id', component: VehiculoComponent },
  { path: 'buscador', component: BuscadorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
