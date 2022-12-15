
/*lass ClaseEjemplo{
    //variables
    propiedadUno;
    propiedadDos;
    propiedadTres;

    //constructores
    constructor(paramUno, paramDos, paramTres) {
        this.propiedadUno = paramUno;
        this.propiedadDos = paramDos;
        this.propiedadTres = paramTres;
    }
    mostrarDatos() {
        console.log(`Propiedad uno: ${this.propiedadUno}`)
        console.log(`Propiedad dos: ${this.propiedadDos}`)
        this.propiedadTres.forEach(element => {
            console.log(element)
        });
    }
    //funciones
    set setPropiedadUno(param) {
        this.propiedadUno = param;
    }
    get getPropiedadUno() {
        return this.propiedadUno;
    }
}*/
class Nota{
    titulo;
    fecha;
    descripcion;
    estado;
    tareas = [];


    constructor(titulo, fecha, estado, descripcion,tareas) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tareas = tareas;
    }
    agregarTarea(tarea) {
        this.tareas.push(tarea)
    
    }
    mostrarDatos() {
        console.log(`Titulo: ${this.titulo}`)
        console.log(`Fecha: ${this.fecha}`)
        if (this.estado) {
            console.log(`Estado: COMPLETADA`)
        } else {
            console.log(`Estado: POR HACER`)
        }
        console.log(`Descripcion: ${this.descripcion}`)
        
        if (this.tareas != null) {
            console.log("Tareas: ");
            this.tareas.forEach(element => {
                element.mostrarDatosTarea();
            });
        }else {
            console.log("No hay tareas");
        }
        
    }
}
class Tarea {
    nombre;
    estado;

    constructor(nombre, estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
    mostrarDatosTarea(){
        console.log(`Nombre: ${this.nombre}`);
        if (this.estado) {
            console.log(`Estado: COMPLETADA`)
        } else {
            console.log(`Estado: POR HACER`)
        }
    }

    set setNombre(param) {
        this.nombre = param;
    }
    get getNombre() {
        return this.nombre;
    }
    set setEstado(param) {
        this.estado = param;
    }
    get getEstado() {
        return this.estado;
    }

}
/*
let ejemploObjeto = new ClaseEjemplo("Propiedad uno", "Propiedad dos", ["param1","param2"]);

ejemploObjeto.setPropiedadUno = "Cambiada"
ejemploObjeto.mostrarDatos();
console.log(ejemploObjeto.getPropiedadUno)
*/