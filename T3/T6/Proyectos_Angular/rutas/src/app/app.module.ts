import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { UnoComponent } from './components/uno/uno.component';
import { DosComponent } from './components/dos/dos.component';
import { ComunicarComponent } from './components/comunicar/comunicar.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UnoComponent,
    DosComponent,
    ComunicarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
