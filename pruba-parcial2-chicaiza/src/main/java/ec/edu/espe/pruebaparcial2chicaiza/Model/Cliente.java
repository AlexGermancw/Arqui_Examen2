package ec.edu.espe.pruebaparcial2chicaiza.Model;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "cliente")
@CompoundIndexes({
        @CompoundIndex(name = "idxu_cliente_cedula", def = "{'cedula': 1}", unique = true)
})

public class Cliente {
    @Id
    private String cedula;

    @Indexed
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String direcciónPrincipal;
    private String telefono;
    private String correoElectronico;

    private List<Cuenta> cuenta;
    private List<Turno> turno;
    private List<Usuario> usuario;
    
}
