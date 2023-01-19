package ec.edu.espe.pruebaparcial2chicaiza.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.pruebaparcial2chicaiza.Model.Cliente;
import ec.edu.espe.pruebaparcial2chicaiza.Model.Usuario;

@Repository  
public interface ClienteRepository extends CrudRepository<Cliente, String>{
    Cliente findByCedula(String cedula);
    Usuario findbyUsuarioByCodigo(String codigo);
    Boolean existsByCedula(String cedula);
    List<Cliente> findAllByOrderByTurnoDesc();
    Cliente findByTurnoCliente(Integer numero);
    
}
