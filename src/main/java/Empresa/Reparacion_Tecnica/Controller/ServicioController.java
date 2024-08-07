package Empresa.Reparacion_Tecnica.Controller;


import Empresa.Reparacion_Tecnica.Models.Cliente;
import Empresa.Reparacion_Tecnica.Models.Servicio;
import Empresa.Reparacion_Tecnica.Models.Tecnico;
import Empresa.Reparacion_Tecnica.Services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RestController
public class ServicioController
{

    @Autowired
     ServicioService ConexionaServicio;

    @RequestMapping(value = "/api/Servicios")
    public List<Servicio> ListadoServicio()
    {
        return ConexionaServicio.ListadoServicio();
    }

    @RequestMapping(value = "/api/servicios/nombres")
    public List<Cliente> ListadoNombre()
    {
        return ConexionaServicio.Findall();
    }

    @RequestMapping(value = "/api/servicios/nombresTec")
    public List<Tecnico> ListadoTecnicos()
    {
        return ConexionaServicio.FindallT();
    }

    @PostMapping (value = "/api/servicios/Registrar")
    public void AgregarServicio(@RequestBody Servicio servicio)
    {
        ConexionaServicio.addService(servicio);
    }




}
