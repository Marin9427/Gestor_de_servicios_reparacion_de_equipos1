// Call the dataTables jQuery plugin
$(document).ready(function() {

CargarServicios();


  $('#ReparaProceso').DataTable();
});




async function CargarServicios()
{
  const request = await fetch('/api/procesos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }

  });
  const ReparaProceso = await request.json();

let listadohtml= '';
for(let reparando of ReparaProceso )
{


let reparacionhtml= '<tr> <td style="text-align: center;">'+reparando.idServicio+ ' </td>  <td style="text-align: center;">'+reparando.nombre_Equipo+'</td>  <td style="text-align: center;">'+reparando.cliente.nombre+'</td>  <td style="text-align: center;">'+reparando.motivo+'</td> <td style="text-align: center;">'+reparando.fechaEntrada+'</td>  <td style="text-align: center;"> '+reparando.tecnico.nombre+ '</td> <td style="text-align: center;"> '+reparando.detalles+ '</td> </tr>'

    listadohtml+=reparacionhtml;
  }



document.querySelector('#ReparaProceso tbody').outerHTML =listadohtml;

}