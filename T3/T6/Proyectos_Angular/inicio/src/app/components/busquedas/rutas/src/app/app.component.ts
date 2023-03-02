import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'rutas';

  constructor(private gestorRutas: Router) {}

  navegarComponente(dato: number) {
    this.gestorRutas.navigate(['comunicar', dato]);
  }
}

