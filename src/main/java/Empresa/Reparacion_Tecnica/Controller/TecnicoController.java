package Empresa.Reparacion_Tecnica.Controller;


import Empresa.Reparacion_Tecnica.Models.Tecnico;
import Empresa.Reparacion_Tecnica.Services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TecnicoController
{

    @Autowired
    TecnicoService tecnicoService;



    @PostMapping(value = "/api/registrartecnico")
    public void RegistrarTecnico(@RequestBody Tecnico tecnic)
    {
        tecnicoService.AgregarTecnico(tecnic);
    }
@RequestMapping(value = "/api/buscarTecnico/{id}")
    public Tecnico getTecnico(@PathVariable Integer id)
    {
        return tecnicoService.FindTecnico(id);
    }


}
