let urlString = "https://dummyjson.com/products";

let selector = document.querySelector("#selector");
let elemento = document.querySelector("#elemento");
fetch(urlString)
  .then((res) => {
    console.log(res);
    return res.json();
  })
  .then((res1) => {
    document.querySelector("#boton_filter").addEventListener("click", () => {
      if (selector.value == "nombre") {
        res1.products.forEach((item) => {
          if (item.title == elemento.value) {
            console.log(`${item.title} ${item.price}`);
          }
        });
      }
    });
  })
  .catch((err) => {
    console.log("fetch resuelta sin exito");
  })
  .finally(() => {
    console.log("Fin de evaluaciones de la promesa");
  });
