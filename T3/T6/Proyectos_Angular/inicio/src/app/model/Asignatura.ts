/*class Asignatura {
  constructor(
    private nombre: string,
    siglas: string,
    ciclo: string,
    curso: number,
    profesor: string,
    conocimientos: string[]
  ) {

  }
}*/

export interface Asignatura {
  nombre: string;
  siglas: string;
  ciclo: string;
  curso: number;
  profesor: string;
  conocimientos: string[];
}
