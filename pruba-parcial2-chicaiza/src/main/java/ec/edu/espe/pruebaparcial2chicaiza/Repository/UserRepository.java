package ec.edu.espe.pruebaparcial2chicaiza.Repository;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.pruebaparcial2chicaiza.Model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
