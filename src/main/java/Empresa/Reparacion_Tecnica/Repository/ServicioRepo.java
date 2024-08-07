package Empresa.Reparacion_Tecnica.Repository;


import Empresa.Reparacion_Tecnica.Models.Servicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class    ServicioRepo
{

    @PersistenceContext
    EntityManager ConexionBDservicio;


    public List<Servicio> ObtenerListadoServicio()
    {
        String query="FROM Servicio"; //apunta al nombre de la clase no de la tabla
        return ConexionBDservicio.createQuery(query).getResultList();
    }

    public List<Object[]> ListaServicioNomvbre()
    {
        String query= "SELECT  idCliente, nombre , apellido FROM Cliente";
        return ConexionBDservicio.createQuery(query).getResultList();
    }

    public List<Object[]> ListaServicioNomvbreT() {
        String query= "SELECT idTecnico ,nombre , apellido FROM Tecnico";
        return ConexionBDservicio.createQuery(query).getResultList();
    }

    public void agregarservicio(Servicio servicio) {
            ConexionBDservicio.merge(servicio);
    }
}
