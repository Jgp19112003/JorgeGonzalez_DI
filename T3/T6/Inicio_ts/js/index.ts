console.log("Primer archivo en ts");
let profesor1 = {
    nombre: "Borja",
    apellido:"Martin",
    asignaturas: [
        {nombre: "Programacion", horas: 8},
        {nombre: "Desarrollo interfaces", horas: 6},
    ]
}

let profesor2 = {
    nombre: "Jesus",
    apellido:"Niño",
    asignaturas: [
        {nombre: "Programacion de procesos", horas: 4},
        {nombre: "Entornos de desarrollo", horas: 3},
    ]
}
let nombre: String = "Borja"
let edad: Number = 38;
let asignaturas: Array<String> = ["DI","PMDM","SGE"];

/*asignaturas.forEach((element) => {
    console.log(element);
});*/

function nombreAsignaturas (asignaturas: Array<any>) {
    asignaturas.forEach((element) => {
        console.log(element);
    });
}

nombreAsignaturas(asignaturas)
