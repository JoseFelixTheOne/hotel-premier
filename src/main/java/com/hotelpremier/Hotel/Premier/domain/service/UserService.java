package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.*;
import com.hotelpremier.Hotel.Premier.domain.repository.UserRepository;
import com.hotelpremier.Hotel.Premier.web.dtosecurity.DtoAuthResponse;
import com.hotelpremier.Hotel.Premier.web.security.JwtGenerator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private UserTypeService userTypeService;
    @Autowired
    private UserTypeMenuService userTypeMenuService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtGenerator jwtGenerator;
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
    public List<User> getByListaByNombreusuario(String username){
        return userRepository.getByListaByNombreusuario(username);
    }
    public Optional<User> getByUsername(String name){
        return userRepository.getByUsername(name);
    }
    @Transactional
    public User save(User user) {

        User newUser = new User();
        newUser.setIdpassenger(user.getIdpassenger());
        newUser.setUser(user.getUser());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<UserType> tipoUsuario = userTypeService.getUserType(user.getUsertpe());
        newUser.setUsertpe(tipoUsuario.get().getUserTypeId());
        newUser.setActive("A");

        Passenger passenger = passengerService.getPassenger(user.getIdpassenger()).get();
        passenger.setPassengerHasUser("1");
        passengerService.update(passenger);

        return userRepository.save(newUser);
    }
    public User update(User user) {
        int iduser = user.getIduser();
        User usuario = getUser(iduser).map(u ->{
            BeanUtils.copyProperties(user, u);
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            u.setActive("A");
            return u;
        }).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + iduser));
        return userRepository.save(usuario);
    }
    @Transactional
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

    @Transactional
    public DtoAuthResponse login(String user, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generarToken(authentication);
        String username = jwtGenerator.obtenerUsernameDeJwt(token);
        User u = userRepository.getByUsername(username).get();
        int userId = u.getIduser();
        String name = u.getObjPassenger().getNames();
        String lastname1 = u.getObjPassenger().getLastname1();
        String lastname2 = u.getObjPassenger().getLastname2();
        String email = u.getObjPassenger().getEmail();
        List<UserTypeMenu> types = userTypeMenuService.getRolesByUserType(u.getUsertpe()).orElse(null);
        List<MenuD> menus = new ArrayList<>();
        for(UserTypeMenu type: types){
            menus.add(type.getMenu());
        }
        return new DtoAuthResponse(token, username , userId, name, lastname1, lastname2, email, menus);
    }

}
