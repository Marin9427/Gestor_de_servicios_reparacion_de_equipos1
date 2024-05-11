package Empresa.Reparacion_Tecnica.Controller;


import Empresa.Reparacion_Tecnica.Models.Cliente;
import Empresa.Reparacion_Tecnica.Models.Servicio;
import Empresa.Reparacion_Tecnica.Models.Tecnico;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ServicioController
{


    @RequestMapping(value = "/api/procesos")
    public List<Servicio> getDatos()
    {
        List<Servicio> LstadoServicios = new ArrayList<>();
        Cliente cliente1=new Cliente("Pedro Infante");
        Tecnico tecnico1=new Tecnico("joseM");

        Servicio usi= new Servicio();
        usi.setIdServicio(1);
        usi.setDetalles("como nuevo");
        usi.setMotivo("No enciente");
        usi.setEstadoequipo("se recibe apagad");
        usi.setNombre_Equipo("Samung grand Prime");
        usi.setCliente(cliente1);
        usi.setTecnico(tecnico1);
        LocalDate fecha1 = LocalDate.of(2024,10,20);
        usi.setFechaEntrada(fecha1);

        Servicio usi2= new Servicio();
        Cliente cliente2=new Cliente("Maria Caramelo");
        usi2.setIdServicio(2);
        usi2.setDetalles("golpe en la orilla");
        usi2.setMotivo("estrellado");
        usi2.setEstadoequipo("Encendido pero no funciona la pantalla");
        usi2.setNombre_Equipo("Hauwei M9");
        usi2.setCliente(cliente2);
        usi2.setTecnico(tecnico1);
        LocalDate fecha2 = LocalDate.of(2024,12,24);
        usi2.setFechaEntrada(fecha2);

        LstadoServicios.add(usi);
        LstadoServicios.add(usi2);
        return LstadoServicios;

    }


}
