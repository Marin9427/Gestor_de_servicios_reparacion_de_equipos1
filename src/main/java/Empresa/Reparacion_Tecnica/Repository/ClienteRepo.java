package Empresa.Reparacion_Tecnica.Repository;

import Empresa.Reparacion_Tecnica.Models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClienteRepo
{

    @PersistenceContext
    EntityManager ConexionAbase;


    public void AgregarCliente(Cliente cliente)
    {
        ConexionAbase.merge(cliente);
    }

    public List<Cliente> MostrarClientes()
    {
            String query="FROM Cliente";
        return ConexionAbase.createQuery(query).getResultList();
    }

    public void DeleteUsr(Integer id)
    {
        Cliente cli = ConexionAbase.find(Cliente.class,id);
        ConexionAbase.remove(cli);
    }

    public Cliente EditarUsuario(Integer id, Cliente editclient)
    {

        Cliente client = ConexionAbase.find(Cliente.class,id);
        client.setNombre(editclient.getNombre());
        client.setApellido(editclient.getApellido());
        client.setTelefono(editclient.getTelefono());
        client.setTelefonoAlt(editclient.getTelefonoAlt());
        client.setDireccion(editclient.getDireccion());
        client.setMunicipio(editclient.getMunicipio());

        return client;
    }
}
