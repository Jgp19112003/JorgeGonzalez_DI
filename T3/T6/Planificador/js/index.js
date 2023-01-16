// crear un json de notas

let nota1 = new Nota("Titulo1", "Descripcion1", new Date());
nota1.agregarTarea(new TareaMultimedia("Titulo Multimedia1", "./ruta"));
nota1.agregarTarea(new TareaMultimedia("Titulo Multimedia2", "./ruta"));
let nota2 = new Nota("Titulo2", "Descripcion2", new Date());
nota2.agregarTarea(new TareaMultimedia("Titulo Multimedia3", "./ruta"));
nota2.agregarTarea(new TareaMultimedia("Titulo Multimedia4", "./ruta"));
let nota3 = new Nota("Titulo3", "Descripcion3", new Date());
let nota4 = new Nota("Titulo4", "Descripcion4", new Date());

let planificador = {
  notas: [
    nota1,
    nota2,
    nota3,
    nota4,
    {
      titulo: "Nota JSON",
      descripcion: "Descripcion JSON",
      fecha: new Date(),
      completa: false,
      tareas: [
        { titulo: "tarea JSON1", completa: false, fichero: "./ruta" },
        new TareaMultimedia("Titulo Multimedia4", "./ruta"),
      ],
    },
  ],
  cantidad: 4,
};

//console.log(planificador);

// sacar el titulo, descr y fecha de todas las notas
planificador.notas.forEach((item) => {
  console.log(item.titulo);
  console.log(item.descripcion);
  console.log(item.fecha);
  // sacar todas las tareas de la nota
  item.tareas.length > 0 && console.log("La lista de tareas es: ");
  item.tareas.forEach((element) => {
    console.log(element.titulo);
  });
});

// recorrer las notas y crear tantas cartas como notas tenga el objeto
