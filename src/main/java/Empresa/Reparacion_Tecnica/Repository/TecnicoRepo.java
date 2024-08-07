package Empresa.Reparacion_Tecnica.Repository;

import Empresa.Reparacion_Tecnica.Models.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Repository
@Transactional
public class TecnicoRepo
{
    @PersistenceContext
    EntityManager ConexiconBaseT;


    public void AddTecnic(Tecnico tecnic)
    {
        ConexiconBaseT.merge(tecnic);
    }


    public Tecnico ecnontrartecnico(Integer id)
    {
       return ConexiconBaseT.find(Tecnico.class,id);
    }
}
