package ec.edu.espe.pruebaparcial2chicaiza.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.pruebaparcial2chicaiza.Controller.DTOs.Req.GenerarTurnoRQ;
import ec.edu.espe.pruebaparcial2chicaiza.Controller.DTOs.Res.ClienteRS;
import ec.edu.espe.pruebaparcial2chicaiza.Controller.Mapper.ClienteMapper;
import ec.edu.espe.pruebaparcial2chicaiza.Model.Cliente;
import ec.edu.espe.pruebaparcial2chicaiza.Service.ClienteService;

@RestController
@RequestMapping("/api/User")
public class ClienteController {

    private final ClienteService clientService;

    public ClienteController(ClienteService clienteService){
        this.clientService = clienteService;
    }

    @GetMapping(value = "/{cedula}")
    public ResponseEntity<ClienteRS> getClienteByCedula(@PathVariable("cedula") String id){
        Cliente client = this.clientService.findClienteByCedula(id);
        if (client != null){
            return ResponseEntity.ok(ClienteMapper.toClientRS(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value="/generarTurno")
    public ResponseEntity<String> generarTurno(@RequestBody GenerarTurnoRQ turnoRQ){
        
        try {
            String result = this.clientService.generarTurno(turnoRQ.getCedula(),turnoRQ.getNombres(),turnoRQ.getApellido());
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
