$(document).ready(function() {

});

async function RegistrarUsuario()
{
  alert("Usuario agregado exitosamente");

let datos= {};

    datos.nombre=document.getElementById('IntNombre').value;
    datos.apellido=document.getElementById('IntApellido').value;
    datos.telefono=document.getElementById('IntTelefono').value;
    datos.telefonoAlt=document.getElementById('IntTelefonoAlt').value;
    datos.direccion=document.getElementById('InpDireccion').value;
    datos.municipio=document.getElementById('InpMunicipio').value;

  const request = await fetch('/api/registrarUsuario', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

    body: JSON.stringify(datos) // Es un método de JavaScript que toma un objeto JavaScript y lo convierte en una cadena de texto JSON

  });

    location.reload(); // carga de nuevo la pagina una vez haga la funcion
}