package Empresa.Reparacion_Tecnica.Services;

import Empresa.Reparacion_Tecnica.Models.Cliente;
import Empresa.Reparacion_Tecnica.Models.Servicio;
import Empresa.Reparacion_Tecnica.Models.Tecnico;
import Empresa.Reparacion_Tecnica.Repository.ServicioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServicioService
{

    @Autowired
     ServicioRepo servicioRepo;


    public List<Servicio> ListadoServicio() {
        return  servicioRepo.ObtenerListadoServicio();
    }

    public List<Cliente> Findall()
    {

        List<Cliente> nombresFormateadoss = new ArrayList<>();
        List<Object[]> nombresApellidoss = servicioRepo.ListaServicioNomvbre();
        for (Object[] nombreApellidoo : nombresApellidoss) {
            // Obtener el ID, el nombre y el apellido de la lista de resultados
            int id = (int) nombreApellidoo[0]; // Convertir el valor a entero
            String nombre = (String) nombreApellidoo[1];
            String apellido = (String) nombreApellidoo[2];

            // Crear una instancia de Tecnico con el ID, el nombre y el apellido
            Cliente cliente = new Cliente();
            cliente.setIdCliente(id);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);

            // Agregar el objeto Tecnico a la lista
            nombresFormateadoss.add(cliente);
        }
        return nombresFormateadoss;

 /**
  *
  *
  *
  *
  *
        List<String> nombresFormateados = new ArrayList<>();
        List<Object[]> nombresApellidos = servicioRepo.ListaServicioNomvbre();
        for (Object[] nombreApellido : nombresApellidos) {
            String nombreCompleto = nombreApellido[0] + " " + nombreApellido[1];
            nombresFormateados.add(nombreCompleto);
        }
        return nombresFormateados;**/
    }


    public List<Tecnico> FindallT() {
        List<Tecnico> nombresFormateadoss = new ArrayList<>();
        List<Object[]> nombresApellidoss = servicioRepo.ListaServicioNomvbreT();
        for (Object[] nombreApellidoo : nombresApellidoss) {
            // Obtener el ID, el nombre y el apellido de la lista de resultados
            int id = (int) nombreApellidoo[0]; // Convertir el valor a entero
            String nombre = (String) nombreApellidoo[1];
            String apellido = (String) nombreApellidoo[2];

            // Crear una instancia de Tecnico con el ID, el nombre y el apellido
            Tecnico tecnico = new Tecnico();
            tecnico.setIdTecnico(id);
            tecnico.setNombre(nombre);
            tecnico.setApellido(apellido);

            // Agregar el objeto Tecnico a la lista
            nombresFormateadoss.add(tecnico);
        }
        return nombresFormateadoss;
    }




    public void addService(Servicio servicio) {
        servicioRepo.agregarservicio(servicio);
    }
}
