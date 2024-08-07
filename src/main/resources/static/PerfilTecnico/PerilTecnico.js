


const allLinks = document.querySelectorAll(".tabs a");
const allTabs = document.querySelectorAll(".tab-content");

allLinks.forEach((elem) => {
  elem.addEventListener("click", function () {
    const linkId = elem.id;
    const hrefLinkClick = elem.href;

    allLinks.forEach((link) => {
      if (link.href == hrefLinkClick) {
        link.classList.add("active");
      } else {
        link.classList.remove("active");
      }
    });

    allTabs.forEach((tab) => {
      const id = tab.id;
      if (id.includes(linkId)) {
        tab.classList.add("tab-content--active");
      } else {
        tab.classList.remove("tab-content--active");
      }
    });
  });
});

MostrarUsuario();


async function MostrarUsuario()
{
  const reque = await fetch('/api/buscarTecnico/2', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const tecnico = await reque.json();
  console.log(tecnico);

document.querySelector('#LblNombre').outerHTML=tecnico.nombre;//apunta a nombre de la columna
document.querySelector('#LblApellido').outerHTML=tecnico.apellido;//apunta a nombre de la columna
document.querySelector('#LblSucursal').outerHTML=tecnico.sucursal;//apunta a nombre de la columna
document.querySelector('#Txtelefono').outerHTML = tecnico.telefono;//apunta a nombre de la columna
document.querySelector('#TxtelefonoAlt').outerHTML = tecnico.telefonoAlterno;//apunta a nombre de la columna
}

LblSucursal