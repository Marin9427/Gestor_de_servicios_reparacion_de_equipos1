package Empresa.Reparacion_Tecnica.Services;

import Empresa.Reparacion_Tecnica.Models.Tecnico;
import Empresa.Reparacion_Tecnica.Repository.TecnicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService
{

    @Autowired
    TecnicoRepo tecnicoRepo;

    public void AgregarTecnico(Tecnico tecnic) {
        tecnicoRepo.AddTecnic(tecnic);
    }


    public Tecnico FindTecnico(Integer id) {
    return tecnicoRepo.ecnontrartecnico(id);
    }
}
