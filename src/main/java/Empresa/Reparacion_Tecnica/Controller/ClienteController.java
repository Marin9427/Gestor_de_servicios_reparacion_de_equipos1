package Empresa.Reparacion_Tecnica.Controller;



import Empresa.Reparacion_Tecnica.Models.Cliente;
import Empresa.Reparacion_Tecnica.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ClienteController
{

    @Autowired
    ClienteService ConexionAservicio;

    @RequestMapping (value = "/api/clientes")
    public List<Cliente> getCliente()
    {
        return ConexionAservicio.showList();
    }


    @PostMapping(value = "/api/registrarUsuario")
    public void Registra(@RequestBody Cliente cliente)
    {
        ConexionAservicio.AddClient(cliente);
    }

    @DeleteMapping(value = "/api/eliminar/{id}")
    public void EliminarUsuario(@PathVariable Integer id)
    {
        ConexionAservicio.DeleteUser(id);
    }

    @PutMapping(value = "/api/Modificar/{id}")
    public Cliente EditarUsuario(@PathVariable Integer id , @RequestBody Cliente editclient)
    {
        return ConexionAservicio.ModificarUsuario(id,editclient);
    }



}
