// Call the dataTables jQuery plugin
$(document).ready(function() {

CargarClientes();


  $('#ListadoCliente').DataTable();
});




async function CargarClientes()
{
  const request = await fetch('/api/clientes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }

  });
  const ListadoClientess = await request.json();

let listadohtml= '';
for(let usuarios of ListadoClientess )
{


let clienteshtml= '<tr> <td style="text-align: center;">'+usuarios.idCliente+ ' </td>  <td style="text-align: center;">'+usuarios.nombre+' '+usuarios.apellido+'</td>  <td style="text-align: center;">'+usuarios.municipio+'</td>  <td style="text-align: center;">'+usuarios.direccion+'</td> <td style="text-align: center;">'+usuarios.telefono+'</td>  <td style="text-align: center;"> '+usuarios.telefonoAlt+ '</td> </tr>'

    listadohtml+=clienteshtml;
  }



document.querySelector('#ListadoCliente tbody').outerHTML =listadohtml;

}