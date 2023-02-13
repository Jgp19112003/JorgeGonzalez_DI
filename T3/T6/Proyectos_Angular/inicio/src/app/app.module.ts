import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicialComponent } from './components/inicial/inicial.component';
import { SecundarioComponent } from './components/secundario/secundario.component';
import { EventosComponent } from './eventos/eventos.component';

@NgModule({
  declarations: [
    AppComponent,
    InicialComponent,
    SecundarioComponent,
    EventosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
