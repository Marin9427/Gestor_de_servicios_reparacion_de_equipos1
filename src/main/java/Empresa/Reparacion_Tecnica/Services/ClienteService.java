package Empresa.Reparacion_Tecnica.Services;

import Empresa.Reparacion_Tecnica.Models.Cliente;
import Empresa.Reparacion_Tecnica.Repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService
{

    @Autowired
    ClienteRepo ConexionReporsitorio;

    public  void DeleteUser(Integer id) {ConexionReporsitorio.DeleteUsr(id);}


    public void AddClient(Cliente cliente)
    {
        ConexionReporsitorio.AgregarCliente(cliente);
    }

    public List<Cliente> showList()
    {
        return ConexionReporsitorio.MostrarClientes();
    }

    public Cliente ModificarUsuario(Integer id, Cliente editclient) { return  ConexionReporsitorio.EditarUsuario(id,editclient);
    }
}
