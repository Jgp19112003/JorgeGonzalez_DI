let urlMonedas = "https://run.mocky.io/v3/16f71bfa-7bee-476f-ab6b-71348547a9d3";
let urlMoneda = "https://api.coingecko.com/api/v3/coins/";
let selector = document.querySelector("#selector");
let row = document.querySelector(".row");
let favoritos = document.querySelector("#favoritos");
monedas = [];
lista_favoritos = [];
let idMoneda = "3air";
let verFavoritos = document.querySelector("#verFavoritos");
let agregarFavorito = document.querySelector("#agregarFavorito");

selector.addEventListener("change", function () {
  row.innerHTML = "";
  cargarCarta(urlMoneda + selector.value);
});

verFavoritos.addEventListener("click", function () {
  if (lista_favoritos.length == 0) {
    alert("La lista de favoritos esta vacia");
  } else {
    favoritos.innerHTML = "";
    lista_favoritos.forEach((element) => {
      favoritos.innerHTML =
        favoritos.innerHTML + `<li class="list-group-item">${element}</li>`;
    });
  }
});

function cargarCarta(urlMoneda) {
  fetch(urlMoneda)
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      row.innerHTML = `<div class="card" style="width: 35rem;">
        <div class="card-body">
            <h5 class="card-title">${res1.name}</h5>
            <p class="card-text">${res1.description.en}</p>
            <a href="${res1.links.homepage[0]}" class="btn btn-primary" id="verDetalles">Ver detalles</a>
        </div>
        <ul class="list-group">
        <li class="list-group-item">${res1.categories}</li>
       </ul>
        <button class="btn btn-primary mt-3" id="agregarFavorito">Agregar como favorita</button>
        </div>
    </div>`;

      let agregarFavorito = document.querySelector("#agregarFavorito");
      agregarFavorito.addEventListener("click", function () {
        lista_favoritos.push(selector.value);
      });
    })
    .catch((rej) => {
      console.log(`Ha habido algún tipo de fallo: ${rej}`);
    });
}

fetch(urlMonedas)
  .then((res) => {
    return res.json();
  })
  .then((res1) => {
    res1.forEach((element) => {
      selector.innerHTML =
        selector.innerHTML +
        `<option class="option" value="${element.id}">${element.name}</option>`;
      monedas.push(element);
    });
  })
  .catch((rej) => {
    console.log(`Ha habido algún tipo de fallo: ${rej}`);
  });

/*JP*/
