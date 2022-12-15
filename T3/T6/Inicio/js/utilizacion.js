/*let ejemploObjetoDos = new ClaseEjemplo("p1","p2",["p3"])
ejemploObjetoDos.mostrarDatos();
*/
//una clase que represente una nota
//titulo, fecha, descripcion, completada , conjunto de tareas

let nota1 = new Nota("Primera nota",new Date(2022,12,15),false,"Hacer practicas de la ultima clase",[new Tarea("Tarea1",false),new Tarea("Tarea2",true)])
nota1.mostrarDatos();