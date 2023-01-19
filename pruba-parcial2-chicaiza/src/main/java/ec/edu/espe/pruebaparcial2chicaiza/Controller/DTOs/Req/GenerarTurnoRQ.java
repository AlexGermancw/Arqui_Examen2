package ec.edu.espe.pruebaparcial2chicaiza.Controller.DTOs.Req;


import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenerarTurno implements Serializable{
    String cedula;
    String nombres;
    String apellido;
}
