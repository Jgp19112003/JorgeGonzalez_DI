import { FactoryTarget } from '@angular/compiler';
import { Component } from '@angular/core';

@Component({
  selector: 'miapp-directivaif',
  templateUrl: './directivaif.component.html',
  styleUrls: ['./directivaif.component.css']
})
export class DirectivaifComponent {
  mostrarElemento =  false
  cambiarElemento(){
    this.mostrarElemento = !this.mostrarElemento
  }

  comprobarEstado(nombre: string){
    if (nombre == "Borja") {
      this.mostrarElemento = true
    } else {
      this.mostrarElemento = false
    }
  }
}
