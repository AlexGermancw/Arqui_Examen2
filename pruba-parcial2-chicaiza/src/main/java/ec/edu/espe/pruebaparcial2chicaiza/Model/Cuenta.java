package ec.edu.espe.pruebaparcial2chicaiza.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cuenta {

    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoPromedio;
    
}
