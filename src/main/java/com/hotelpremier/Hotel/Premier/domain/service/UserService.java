package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAll(){
        System.out.println("FALTA IMPLEMENTAR USER SERVICE");
        return userRepository.getAll();
    }
    public List<User> getAllActive(){

        System.out.println("FALTA IMPLEMENTAR USER SERVICE");
        return userRepository.getAllActive();
    }
    public List<User> getAllInactive(){
        return userRepository.getAllInactive();
    }

    public Optional<User> getUser(int iduser) {
        return userRepository.getUser(iduser);
    }

    public List<User> getByNombreusuario(String username){
        return userRepository.getByNombreusuario(username);
    }

    public User save(User user) {
        user.setActive("A");
        return userRepository.save(user);
    }

    public User update(User user) {
        int iduser = user.getIduser();
        User usuario = getUser(iduser).map(u ->{
            BeanUtils.copyProperties(user, u);
            return u;
        }).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + iduser));
        return userRepository.save(usuario);
    }

    public void delete(int userId) {
        if (getUser(userId).isPresent()) {
            User user = userRepository.getUser(userId).get();
            user.setActive("I");
            userRepository.save(user);
        }
        else {
            System.out.println("ERROR 404 : USER NOT FOUND");
        }
    }

    public boolean existsByUsuarioacceso (String username){
        return userRepository.existsByUsuarioacceso(username);
    }

    public boolean existsByIdpasajero(int idpasajero){
        return userRepository.existsByIdpasajero(idpasajero);
    }
}
