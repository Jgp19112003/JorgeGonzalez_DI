console.log("Primer archivo en ts");
var profesor1 = {
    nombre: "Borja",
    apellido: "Martin",
    asignaturas: [
        { nombre: "Programacion", horas: 8 },
        { nombre: "Desarrollo interfaces", horas: 6 },
    ]
};
var profesor2 = {
    nombre: "Jesus",
    apellido: "Niño",
    asignaturas: [
        { nombre: "Programacion de procesos", horas: 4 },
        { nombre: "Entornos de desarrollo", horas: 3 },
    ]
};
var nombre = "Borja";
var edad = 38;
var asignaturas = ["DI", "PMDM", "SGE"];
/*asignaturas.forEach((element) => {
    console.log(element);
});*/
function nombreAsignaturas(asignaturas) {
    asignaturas.forEach(function (element) {
        console.log(element);
    });
}
nombreAsignaturas(asignaturas);
