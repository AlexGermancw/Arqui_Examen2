package ec.edu.espe.pruebaparcial2chicaiza.Controller.Mapper;

import ec.edu.espe.pruebaparcial2chicaiza.Controller.DTOs.Res.ClienteRS;
import ec.edu.espe.pruebaparcial2chicaiza.Model.Cliente;

//import com.picadoexamen2p.examen2p.Controller.DTOs.Req.UserReq;
//import com.picadoexamen2p.examen2p.Controller.DTOs.Res.UserRes;
//import com.picadoexamen2p.examen2p.Model.User;

public class ClienteMapper {

    public static ClienteRS toClientRS(Cliente client){
        return ClienteRS.builder()
            .cedula(client.getCedula())
            .nombresCompleto(client.getNombres()+" "+client.getApellidos())
            .fechaNacimiento(client.getFechaNacimiento())
            .direcciónPrincipal(client.getDirecciónPrincipal())
            .telefono(client.getTelefono())
            .correoElectronico(client.getCorreoElectronico())
            .build();
    }
}
