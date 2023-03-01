import { Injectable } from '@angular/core';
import { Asignatura } from '../model/Asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  // datos

  private asignaturas: Asignatura[] = [
    {
      nombre: 'Desarrollo cliente',
      siglas: 'DC',
      curso: 2,
      ciclo: 'DAW',
      profesor: 'Borja Martin',
      conocimientos: ['JS', 'Express', 'React'],
    },
    {
      nombre: 'Desarrollo servidor',
      siglas: 'DS',
      curso: 2,
      ciclo: 'DAW',
      profesor: 'David Ventura',
      conocimientos: ['PHP', 'Servicios', 'WebService'],
    },
    {
      nombre: 'Programacion multimedia',
      siglas: 'PMDM',
      curso: 2,
      ciclo: 'DAM',
      profesor: 'Borja Martin',
      conocimientos: ['Kotlin', 'xml', 'java'],
    },
    {
      nombre: 'Desarrollo de interfaces ',
      siglas: 'DI',
      curso: 2,
      ciclo: 'DAM',
      profesor: 'Borja Martin',
      conocimientos: ['Java', 'JS', 'Angular'],
    },
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      curso: 1,
      ciclo: 'DAM|DAW',
      profesor: 'Borja Martin',
      conocimientos: ['Java'],
    },
    {
      nombre: 'Base datos',
      siglas: 'BD',
      curso: 1,
      ciclo: 'DAM|DAW',
      profesor: 'Luis Hermida',
      conocimientos: ['MySQL', 'Mongo', 'SQL', 'NSQL'],
    },
  ];

  constructor() {}

  getAllAsignaturas(): Asignatura[] {
    this.asignaturas.filter((item) => {
      // retornar la condicion de busqueda
    }); // lista con todas las asignaturas que cumplan filtro de busqueda

    return this.asignaturas;
  }

  getAsignaturasFiltradas(numero: number): Asignatura[] {
    if (numero == 1 || numero == 2) {
      return this.asignaturas.filter(
        (item: Asignatura) => item.curso == numero
      );
    } else {
      return this.getAllAsignaturas();
    }
  }
}
