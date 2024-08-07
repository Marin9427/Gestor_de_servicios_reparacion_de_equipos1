$(document).ready(function() {
    fetch('/api/servicios/nombres')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('selectNombres');
            data.forEach(nombre => {
                const option = document.createElement('option');
                option.value = nombre.idCliente;
                option.textContent = `${nombre.nombre} ${nombre.apellido}`;
                select.appendChild(option);
            });
        })
        .catch(error => console.error('Error al obtener nombres de clientes:', error));

    fetch('/api/servicios/nombresTec')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('selectTecnicos');
            data.forEach(nombres => {
                const option = document.createElement('option');
                option.value = nombres.idTecnico;
                option.textContent = `${nombres.nombre} ${nombres.apellido}`;
                select.appendChild(option);
            });
        })
        .catch(error => console.error('Error al obtener nombres de técnicos:', error));
});

async function RegistrarServicio() {
    alert("Proceso agregado exitosamente");

    let nombre_Equipo = document.getElementById('TxtNombre').value;
    let motivo = document.getElementById('TxtMotivo').value;
    let fechaEntrada = document.getElementById('FechaT').value;
    let detalles = document.getElementById('Comentt').value;
    let tecnicoSelect = document.getElementById('selectTecnicos').value;
    let clienteSelect = document.getElementById('selectNombres').value;

    let datos = {
        nombre_Equipo: nombre_Equipo,
        motivo: motivo,
        fechaEntrada: fechaEntrada,
        detalles: detalles,
        cliente: {
            idCliente: clienteSelect
        },
        tecnico: {
            idTecnico: tecnicoSelect // Corregido aquí
        }
    };

    try {
        const response = await fetch('/api/servicios/Registrar', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        // Handle response if needed
        console.log('Respuesta del servidor:', response);

        // Optionally redirect or update UI instead of reloading the entire page
        // window.location.href = '/ruta/nueva';
        // updateUI();

        location.reload(); // Solo como ejemplo, evalúa si realmente necesitas recargar la página
    } catch (error) {
        console.error('Error al registrar el servicio:', error);
        // Handle error: mostrar mensaje al usuario, revertir cambios, etc.
    }
}
