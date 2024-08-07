package Empresa.Reparacion_Tecnica.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Servicio
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservicio")
    private int idServicio;

    @ManyToOne
    @JoinColumn(name = "idTecnico" , referencedColumnName = "idTenico")
    public Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "idCliente" , referencedColumnName = "idcliente")
    public Cliente cliente;

    @Column(name = "nombreEquipo")
    private String nombre_Equipo;

    @Column(name = "motivo")
    private String  motivo;

    @Column(name = "estadoequipo")
    private String  estadoequipo;

    @Column(name = "detalles")
    private String detalles;

    @Column(columnDefinition = "DATETIME" , name = "fechaEntrada" ,updatable = false , nullable = false)
    private LocalDate fechaEntrada; //se puso LocalDate en lugar de DATE

    @Column(columnDefinition = "DATETIME" , name = "fechaSalida" ,updatable = false )
    private LocalDate fechaSalida;  //se puso LocalDate en lugar de DATE


}
