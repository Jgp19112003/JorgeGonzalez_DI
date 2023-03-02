import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuscadorComponent } from './components/buscador/buscador.component';
import { MaincomponentComponent } from './components/maincomponent/maincomponent.component';
import { VehiculoComponent } from './components/vehiculo/vehiculo.component';

const routes: Routes = [
  { path: 'vehiculo', component: VehiculoComponent },
  { path: 'maincomponent', component: MaincomponentComponent },
  { path: 'buscador', component: BuscadorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
