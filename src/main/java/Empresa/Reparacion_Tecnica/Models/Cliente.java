package Empresa.Reparacion_Tecnica.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private int idCliente;

    @Column(name = "nombre")
    private String  nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "telefonoalt")
    private String telefonoAlt;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "municipio")
    private String municipio;




public Cliente(String nombre)
{
    this.nombre=nombre;
}


}
