package ec.edu.espe.pruebaparcial2chicaiza.Service;

import org.springframework.stereotype.Service;

import ec.edu.espe.pruebaparcial2chicaiza.Model.User;
import ec.edu.espe.pruebaparcial2chicaiza.Repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public ec.edu.espe.pruebaparcial2chicaiza.Model.User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
