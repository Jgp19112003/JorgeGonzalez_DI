/*let elementoPorId = document.getElementById("lista");
console.log(elementoPorId);
let elementoPorTag = document.getElementsByTagName("li");
console.log(elementoPorTag);
let elementoPorClass = document.getElementsByClassName("m-5");
console.log(elementoPorClass);


let elementoQuery = document.querySelector("#lista");
console.log(elementoQuery);
let elementoQueryAll = document.querySelectorAll("#lista");
console.log(elementoQueryAll);

let elementoQueryAll = document.querySelectorAll("ul.clase2 li");
elementoQueryAll.forEach((element) => {
    console.log(element.textContent);
});

let elementoLista = document.querySelectorAll("ul.clase2");
let nodoLI = document.createElement("li");
nodoLI.classList.add("list-group-item");
nodoLI.innerText = "Elemento 66";
elementoLista[0].append(nodoLI)


let elementoLista = document.querySelector("ul.clase2");
let listaHTML = elementoLista.innerHTML + `<li class="list-group-item">Elemento 66</li>`;

elementoLista.innerHTML = listaHTML;


let elementoLista = document.querySelector("ul.clase2");
let nodoLIBuscado = document.querySelector(".elemento3");
elementoLista.removeChild(nodoLIBuscado);
*/

let selector = document.querySelector("#selector")

document.querySelector("#boton_add").addEventListener("click", () => {
    if (selector.value == "lista1") {
        let elementoLista = document.querySelector("ul.clase1");
        let listaHTML = elementoLista.innerHTML + `<li class="list-group-item">Elemento Nuevo</li>`;

        elementoLista.innerHTML = listaHTML;
    }
    if (selector.value == "lista2") {
        let elementoLista = document.querySelector("ul.clase2");
        let listaHTML = elementoLista.innerHTML + `<li class="list-group-item">Elemento Nuevo</li>`;

        elementoLista.innerHTML = listaHTML;
    }
});
