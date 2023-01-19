package ec.edu.espe.pruebaparcial2chicaiza.Model;
import java.security.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Turno {
    
    private Integer numeroTurno;
    private String cedulaCliente;
    private String nombreCliente;
    private String codigoUsuario;
    private String nombreEjecutivo;
    private Timestamp fechaGeneracion;
    private Timestamp inicioAtencion;
    private Timestamp finAtencion;
    private Integer calificacion;
    
}
