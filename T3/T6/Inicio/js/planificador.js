let planificador = []

let nota1 = new Nota("Primera nota",new Date(),false,"Hacer practicas de la ultima clase",[new Tarea("Tarea1",false),new Tarea("Tarea2",true)])
let nota2 = new Nota("Segunda nota",new Date(),false,"Comprar comida",[new Tarea("Tarea3",false),new Tarea("Tarea4",true)])
let nota3 = new Nota("Tercera nota",new Date(),false,"Ver el futbol",[new Tarea("Tarea5",false),new Tarea("Tarea6",true)])

planificador.push(nota1)
planificador.push(nota2)
planificador.push(nota3)

planificador.forEach(element => {
    element.mostrarDatos();
});
