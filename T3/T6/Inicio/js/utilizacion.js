/*let ejemploObjetoDos = new ClaseEjemplo("p1","p2",["p3"])
ejemploObjetoDos.mostrarDatos();
*/
//una clase que represente una nota
//titulo, fecha, descripcion, completada , conjunto de tareas

let nota1 = new Nota("Primera nota",new Date(),false,"Hacer practicas de la ultima clase",[new Tarea("Tarea1",false),new Tarea("Tarea2",true)])
//nota1.agregarTarea(new Tarea("Tarea2",false))
nota1.completarTarea("Tarea1");
nota1.marcarCompleta();
nota1.mostrarDatos();