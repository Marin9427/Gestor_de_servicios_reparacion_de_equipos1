$(document).ready(function() {

});

async function RegistrarTecnico()
{
    alert("Tecnico agregado Exitosamente");

let datos ={};

datos.nombre=document.getElementById('IntNombreT').value;
datos.apellido=document.getElementById('IntApellidoT').value;
datos.telefono=document.getElementById('IntTelefonoT').value;
datos.telefonoAlterno=document.getElementById('IntTelefonoAltT').value;
datos.direccion=document.getElementById('InpDireccionT').value;
datos.sucursal=document.getElementById('InpSucursalT').value;
datos.diaDescanso=document.getElementById('InpDescansoT').value;




const rawResponse = await fetch('/api/registrartecnico', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

 location.reload();


}


