console.log("Script ejecutado desde fuera")

// Variable
let numero = 5;
let numeroDecimal = 3.14;
let palaras = "Ejemplo de palabras";
let letras = "A";
let experiencia = true;
let sinDefinir = undefined;
let objeto = null;
let coleccion = [];
let fechaActual = new Date();

console.log(typeof numero);
console.log(typeof numeroDecimal);
console.log(typeof palaras);
console.log(typeof letras);
console.log(typeof experiencia);
console.log(typeof sinDefinir);
console.log(typeof objeto);
console.log(typeof coleccion);
console.log(typeof fechaActual);

let op1 = Number (prompt("Introduce primer operando"))
let op2 = Number (prompt("Introduce segundo operando"))

let suma = op1 + op2
let resta = op1 - op2
let multiplicacion = op1 * op2
let division = op1 / op2;

if(!isNaN(op1) && !isNaN(op2)){
    console.log(suma);
    console.log(resta);
    console.log(multiplicacion);
    console.log(division);
}

