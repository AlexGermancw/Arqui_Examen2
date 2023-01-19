package ec.edu.espe.pruebaparcial2chicaiza.Service;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mongodb.internal.connection.Time;

import ec.edu.espe.pruebaparcial2chicaiza.Model.Cliente;
import ec.edu.espe.pruebaparcial2chicaiza.Model.Turno;
import ec.edu.espe.pruebaparcial2chicaiza.Model.Usuario;
import ec.edu.espe.pruebaparcial2chicaiza.Repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente findClienteByCedula(String cedula){
        Boolean clientExists = this.clienteRepository.existsByCedula(cedula);
        if (!clientExists){
            throw new RuntimeException("The client does not exist");
        }
        return this.clienteRepository.findByCedula(cedula);
    }

    public Integer obtenerTurno(){
        List<Cliente> clientes = clienteRepository.findAllByOrderByTurnoDesc();
        if(!clientes.isEmpty()){
            return 0;
        }
        Cliente lastClient = clientes.get(0);
        return lastClient.getTurno().get(0).getNumeroTurno()+1;        
    }

    public String generarTurno(String cedula, String nombres, String apellidos){
        Integer numeroTurno = obtenerTurno();
        Cliente cliente = findClienteByCedula(cedula);
        if(cliente==null){
            throw new RuntimeException("The client does not exist");
        }
        try {
            cliente.getTurno().add(new Turno());
            cliente.getTurno().get(0).setNumeroTurno(numeroTurno);
            clienteRepository.save(cliente);
            return "Turno Generado";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String resgistroInicioAtencion(Integer turno, String codigoUsuario){
        Cliente cliente = clienteRepository.findByTurnoCliente(turno);

        if(cliente==null){
            throw new RuntimeException("The client does not exist");
        }

        try {
            Usuario usuario = clienteRepository.findbyUsuarioByCodigo(codigoUsuario);
            Timestamp hora = new Timestamp(null, null);
            cliente.getTurno().get(0).setInicioAtencion(hora);
            cliente.getUsuario().add(usuario);
            clienteRepository.save(cliente);
            return  "Inicio Atencion";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public String resgistroFinAtencion(Integer turno, Timestamp date){
        Cliente cliente = clienteRepository.findByTurnoCliente(turno);

        if(cliente==null){
            throw new RuntimeException("The client does not exist");
        }

        try {
            cliente.getTurno().get(0).setFinAtencion(date);;
            clienteRepository.save(cliente);
            return  "Calificacion";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public String resgistroCalificacion(String cedula, Integer numeroTurno, Integer calificacion){
        Cliente cliente = clienteRepository.findByCedula(cedula);
        if(cliente==null){
            throw new RuntimeException("The client does not exist");
        }

        try {
            cliente.getTurno().get(0).setCalificacion(calificacion);;
            clienteRepository.save(cliente);
            return  "Inicio Atencion";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

}
