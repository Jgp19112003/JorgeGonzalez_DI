import { Component } from '@angular/core';

@Component({
  selector: 'directivas-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css'],
})
export class EventosComponent {
  alumno = {
    nombre: '',
    apellido: '',
    ciclo: "",
    experiencia: "",
    estudios:""
  };

  estudios = ""
  cicloSeleccionado: string = "";
  ciclos = [
    "Bachillerato",
    "FP",
    "Universidad"
  ]

  urlImagen =
    'https://digital55.com/wp-content/uploads/2022/01/Renderizado_en_servidor_con_angular_universal.png';

  pulsacionBotonIncial(nombre: string, apellido: string, ciclo: string, experiencia: boolean) {

    this.alumno.nombre = nombre;
    this.alumno.apellido = apellido;
    this.alumno.ciclo = ciclo;
    this.alumno.estudios = this.estudios
    if(experiencia){
    this.alumno.experiencia = "Tiene experiencia"
    } else {
      this.alumno.experiencia = "No tiene experiencia"
    }
  }

  capturaCambioRadio(estudios: string) {
    this.estudios = estudios
  }

  capturaEvento(evento: any){
    console.log(evento.target.value);

  }

}
