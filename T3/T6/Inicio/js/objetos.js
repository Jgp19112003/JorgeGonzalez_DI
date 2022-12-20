
/*class ClaseEjemplo{
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
class TareaMultimedia extends Tarea {
    fichero;
    constructor(nombre, estado, fichero) {
        super(nombre,estado);
        this.fichero = fichero
    }
    mostrarDatosTarea(){
        super.mostrarDatosTarea();
        console.log(`Fichero: ${this.fichero}`)
    }

    set setFichero(fichero){
        this.fichero = fichero
    }
}
class TareaTexto extends Tarea {
    descripcion;
    constructor(nombre, estado, descripcion) {
        super(nombre, estado);
        this.descripcion = descripcion
    }

    mostrarDatosTarea(){
        super.mostrarDatosTarea();
        console.log(`Descripcion: ${this.descripcion}`)
    }
    
    set setDescripcion(descripcion){
        this.descripcion = descripcion
    }
}
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
        //this.tareas.filter((item) => item.nombre == tarea.nombre ).length > 0 ? alert("Ya existe esa tarea") :  this.tareas.push(tarea)     
        this.tareas.some((item) => item.nombre == tarea.nombre) ? alert("Ya existe esa tarea") :  this.tareas.push(tarea)
    }
    completarTarea(nombre){
        this.tareas.find((item) => item.nombre == nombre).estado = true
    }
    marcarCompleta(){
        this.tareas.some((item) => item.estado == false) ? alert("Todavia quedan tareas por hacer") : nota1.estado = true
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
/*
let ejemploObjeto = new ClaseEjemplo("Propiedad uno", "Propiedad dos", ["param1","param2"]);

ejemploObjeto.setPropiedadUno = "Cambiada"
ejemploObjeto.mostrarDatos();
console.log(ejemploObjeto.getPropiedadUno)
*/