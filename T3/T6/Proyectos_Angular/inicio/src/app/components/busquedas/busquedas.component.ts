import { Component } from '@angular/core';

@Component({
  selector: 'miapp-busquedas',
  templateUrl: './busquedas.component.html',
  styleUrls: ['./busquedas.component.css']
})
export class BusquedasComponent {
  alumnos: any [] = []
  filtrando: boolean = false
  seleccionFiltro = ""
  estudios = ""
  registrados = 0
  filtro = 0


  pulsacionBotonIncial(nombreP: string,
    apellidoP: string,
    cicloP: string,
    experienciaP: boolean)
     {
    this.filtro == 0
    if (nombreP == "" || apellidoP == "" || this.estudios == "") {
      alert("Rellena todos los datos del formulario")
    } else {
      let alumno = {
        nombre: nombreP,
        apellido: apellidoP,
        experiencia: experienciaP,
        ciclo: cicloP,
        estudios: this.estudios,
      };
      this.registrados++

        // crear alumno, porque cuando introduzco alumno, se me cambian los demas por el introducido
        this.alumnos.push(alumno)

      this.alumnos.forEach(element => console.log(element));
    }
  }
  pulsacionBotonBuscar(ciclo: string = "",estudios: string = ""){
    this.filtrando = true
    if (ciclo == "" && estudios == "") {
      alert("Selecciona algun filtro")
    }
    if (this.seleccionFiltro == "filtro1") {
      if (ciclo == "DAM") {
        this.filtro = this.alumnos.filter(alumno => alumno.ciclo == "DAM").length
      }
      if (ciclo == "DAW") {
        this.filtro = this.alumnos.filter(alumno => alumno.ciclo == "DAW").length
      }
      if (ciclo == "ASIR") {
        this.filtro = this.alumnos.filter(alumno => alumno.ciclo == "ASIR").length
      }
    }
    if (this.seleccionFiltro == "filtro2") {
      if (estudios == "Bachillerato") {
        this.filtro = this.alumnos.filter(alumno => alumno.estudios == "Bachillerato").length
      }
      if (estudios == "FP") {
        this.filtro = this.alumnos.filter(alumno => alumno.estudios == "FP").length
      }
      if (estudios == "Universidad") {
        this.filtro = this.alumnos.filter(alumno => alumno.estudios == "Universidad").length
      }
    }
    console.log(this.filtro);
  }

  capturaEvento(evento: any){
    this.estudios = evento.target.value;
  }
  capturaEventoFiltro(evento: any){
    this.seleccionFiltro = evento.target.value;
  }
}
