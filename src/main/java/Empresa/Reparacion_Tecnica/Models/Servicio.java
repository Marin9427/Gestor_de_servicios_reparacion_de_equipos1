package Empresa.Reparacion_Tecnica.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Servicio
{

    private int idServicio;


    private Tecnico tecnico;


    private Cliente cliente;

    private String nombre_Equipo;


    private String  motivo;


    private String  estadoequipo;


    private String detalles;


    private LocalDate fechaEntrada; //se puso LocalDate en lugar de DATE

    private LocalDate fechaSalida;  //se puso LocalDate en lugar de DATE


}
