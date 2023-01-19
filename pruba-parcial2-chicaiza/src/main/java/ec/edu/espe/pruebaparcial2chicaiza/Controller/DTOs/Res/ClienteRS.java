package ec.edu.espe.pruebaparcial2chicaiza.Controller.DTOs.Res;

import java.io.Serializable;
import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRS implements Serializable {
    
    private String cedula;
    private String nombresCompleto;
    private Date fechaNacimiento;
    private String direcciónPrincipal;
    private String telefono;
    private String correoElectronico;
    
}
