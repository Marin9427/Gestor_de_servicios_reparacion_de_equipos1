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

    body: JSON.stringify(datos)

  });

    location.reload();
}