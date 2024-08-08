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
public class Tecnico
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTenico")
    private int idTecnico;

    @Column(name = "nombre")
    private String  nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "telefonoAlterno")
    private String telefonoAlterno;

    @Column(name = "direccion")
    private  String direccion;

    @Column(name = "sucursal")
    private String Sucursal;

    @Column(name = "diaDescanso")
    private String DiaDescanso;


public  Tecnico (String nombre )
{
    this.nombre=nombre;
}

}
