// Call the dataTables jQuery plugin
$(document).ready(function() {

    AdministrarUsuario();

    $('#ListadoClienteEditar').DataTable();
});

async function AdministrarUsuario() {
    const request = await fetch('/api/clientes', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const ListadoClientes = await request.json();

    let listadohtml= '';
    for(let usuario of ListadoClientes) {
        let botonEliminar = '<a href="#" onclick="EliminarUsuario('+usuario.idCliente+')" class="btn btn-danger btn-icon-split"> <span class="icon text-white-50"> <i class="fas fa-trash"></i> </span> <span class="text">Eliminar Usuario</span></a>';
        let Modificar = '<a href="#" class="btn btn-warning btn-icon-split btn-prueba-modal" data-id="'+usuario.idCliente+'"> <span class="icon text-white-50">  <i class="fas fa-pen"></i> </span> <span class="text">Modificar Usuario</span></a>';

        let clienteshtml= '<tr> <td style="text-align: center;">'+usuario.idCliente+ ' </td>  <td style="text-align: center;">'+usuario.nombre+' '+usuario.apellido+' </td> <td style="text-align: center;">'+ Modificar + '            ' +botonEliminar+' </td>  </tr>';

        listadohtml += clienteshtml;
    }
    document.querySelector('#ListadoClienteEditar tbody').innerHTML = listadohtml;


    const botonesModificar = document.querySelectorAll(".btn-prueba-modal");
    botonesModificar.forEach(boton => {
        boton.addEventListener("click", () => {
            const idCliente = boton.dataset.id;
            EditarTexto(idCliente);
        });
    });
}

async function EliminarUsuario(id) {
    if(!confirm('¿Desea eliminar este cliente?')) {
        return;
    }

    const request = await fetch('/api/eliminar/'+ id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    location.reload();
}

async function EditarTexto(id) {
    const modal = document.querySelector("#Modal");
    modal.showModal();

    const btnCerrarModal = document.querySelector("#btn-cerrar-modal");
    const btnGuardarModal = document.querySelector("#btn-Guardar-modal");


    btnCerrarModal.addEventListener("click", () => {
        modal.close();
    });

btnGuardarModal.addEventListener("click", async () => {
    const Modificarlo = {
        nombre: document.getElementById('txtNombre').value,
        apellido: document.getElementById('txtApellidos').value,
        telefono: document.getElementById('txtTelefono').value,
        telefonoAlt: document.getElementById('txtTelefonoAlt').value,
        direccion: document.getElementById('txtDireccion').value,
        municipio: document.getElementById('Municipio').value
    };

    try {
        const response = await fetch('/api/Modificar/' + id, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(Modificarlo)
        });

        if (response.ok) {

           alert("Usuario modificado exitosamente");
        } else {

            console.error("Hubo un problema al modificar el usuario");
        }
    } catch (error) {

        console.error("Error al intentar modificar el usuario:", error);
    }

    modal.close();
  location.reload();

});


 };

