package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PassengerService passengerService;
    public List<User> getAll(){
        return userRepository.getAll();
    }
    public List<User> getAllActive(){
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
    public List<User> getByUser(String name){
        return userRepository.getByNombreusuario(name);
    }
    public User save(User user) {
        System.out.println("Id Pasajero: " + user.getIdpassenger());
        Passenger passenger = passengerService.getPassenger(user.getIdpassenger()).get();
        passenger.setPassengerHasUser("1");
        passengerService.update(passenger);
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
            Passenger passenger = passengerService.getPassenger(user.getIdpassenger()).get();
            passenger.setPassengerHasUser("0");
            passengerService.update(passenger);
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
