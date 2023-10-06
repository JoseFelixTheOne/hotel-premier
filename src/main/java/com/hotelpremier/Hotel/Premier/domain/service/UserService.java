package com.hotelpremier.Hotel.Premier.domain.service;

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

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int iduser) {
        return userRepository.getUser(iduser);
    }

    public Optional<User> getByUsuarioaccesoAndClave(String user, String password){
        return userRepository.getByUsuarioaccesoAndClave(user, password);
    }
    public User save(User user) {
        return  userRepository.save(user);
    }

    public User update(User user) {
        int iduser = user.getIduser();
        User usuario = getUser(iduser).map(u ->{
            BeanUtils.copyProperties(user, u);
            return u;
        }).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + iduser));
        return userRepository.save(usuario);
    }

    public boolean delete(int iduser) {
        if (getUser(iduser).isPresent()) {
            userRepository.delete(iduser);
            return true;
        }else {
            return  false;
        }
    }
}
