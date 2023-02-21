import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicialComponent } from './components/inicial/inicial.component';
import { SecundarioComponent } from './components/secundario/secundario.component';
import { EventosComponent } from './eventos/eventos.component';
import { DirectivaifComponent } from './components/directivaif/directivaif.component';
import { DirectivaswitchComponent } from './components/directivaswitch/directivaswitch.component';
import { BusquedasComponent } from './components/busquedas/busquedas.component';
import { DirectivaforComponent } from './components/directivafor/directivafor.component';

@NgModule({
  declarations: [
    AppComponent,
    InicialComponent,
    SecundarioComponent,
    EventosComponent,
    DirectivaifComponent,
    DirectivaswitchComponent,
    BusquedasComponent,
    DirectivaforComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
