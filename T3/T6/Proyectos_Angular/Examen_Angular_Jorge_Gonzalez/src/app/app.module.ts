import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VehiculoComponent } from './components/vehiculo/vehiculo.component';
import { BuscadorComponent } from './components/buscador/buscador.component';

@NgModule({
  declarations: [
    AppComponent,
    VehiculoComponent,
    BuscadorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
