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
            int id = (int) nombreApellidoo[0];
            String nombre = (String) nombreApellidoo[1];
            String apellido = (String) nombreApellidoo[2];
            Cliente cliente = new Cliente();
            cliente.setIdCliente(id);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            nombresFormateadoss.add(cliente);
        }
        return nombresFormateadoss;

    }


    public List<Tecnico> FindallT() {
        List<Tecnico> nombresFormateadoss = new ArrayList<>();
        List<Object[]> nombresApellidoss = servicioRepo.ListaServicioNomvbreT();
        for (Object[] nombreApellidoo : nombresApellidoss) {
            int id = (int) nombreApellidoo[0];
            String nombre = (String) nombreApellidoo[1];
            String apellido = (String) nombreApellidoo[2];
            Tecnico tecnico = new Tecnico();
            tecnico.setIdTecnico(id);
            tecnico.setNombre(nombre);
            tecnico.setApellido(apellido);
            nombresFormateadoss.add(tecnico);
        }
        return nombresFormateadoss;
    }
    public void addService(Servicio servicio) {
        servicioRepo.agregarservicio(servicio);
    }
}
