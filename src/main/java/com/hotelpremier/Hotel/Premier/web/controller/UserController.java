package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.domain.dto.RegisterUserDTO;
import com.hotelpremier.Hotel.Premier.domain.service.PassengerService;
import com.hotelpremier.Hotel.Premier.domain.service.UserService;
import com.hotelpremier.Hotel.Premier.domain.service.UserTypeService;
import com.hotelpremier.Hotel.Premier.persistence.crud.PasajeroCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.TipoUsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.UsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.web.dtosecurity.DtoAuthResponse;
import com.hotelpremier.Hotel.Premier.web.dtosecurity.DtoLogin;
import com.hotelpremier.Hotel.Premier.web.dtosecurity.DtoRegistro;
import com.hotelpremier.Hotel.Premier.web.security.JwtGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    //Inyección de dependencias
    @Autowired
    private UserService userService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private UserTypeService userTypeService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtGenerator jwtGenerator;
    //Listado de activos
    @GetMapping({"", "/"})
    public ResponseEntity<List<User>> getAllActive() {
        return new ResponseEntity<>(userService.getAllActive(), HttpStatus.OK);
    }
    //Listado de inactivos
    @GetMapping("/inactive")
    public ResponseEntity<List<User>> getAllInactive() {
        return new ResponseEntity<>(userService.getAllInactive(), HttpStatus.OK);
    }
    //Listado total de los Usuarios
    @GetMapping("/listAll")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    //Usuario filtrado por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int iduser) {
        return userService.getUser(iduser)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //Búsqueda de usuario por username
    @GetMapping("/username/{username}")
    public ResponseEntity<List<User>> getByUsuarioacceso(@PathVariable("username") String username){
        return new ResponseEntity<>(userService.getByListaByNombreusuario(username), HttpStatus.OK);

    }
    //Registro de Usuario
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody DtoRegistro dtoRegistro){
        Passenger passenger = passengerService.getPassenger(dtoRegistro.getIdpassenger()).get();
        User user = new User();
        boolean userexists = userService.existsByUsuarioacceso(dtoRegistro.getUser());
        boolean personexists = passengerService.existsById(dtoRegistro.getIdpassenger());
        boolean personhasuser = userService.existsByIdpasajero(dtoRegistro.getIdpassenger());
        if (!personexists){
            return new ResponseEntity<>("El pasajero no está registrado", HttpStatus.BAD_REQUEST);
        }
        else if(userexists){
            return new ResponseEntity<>("El nombre de usuario se encuentra en uso", HttpStatus.BAD_REQUEST);
        }
        else if (personhasuser){
            if(passenger.getActive().equals("A")){
                return new ResponseEntity<>("El pasajero ya tiene un usuario creado", HttpStatus.BAD_REQUEST);
            }
            else{
                BeanUtils.copyProperties(dtoRegistro, user);
                return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
            }
        }
        else{
            BeanUtils.copyProperties(dtoRegistro, user);
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
        }
    }
    @PostMapping("register")
    @ResponseStatus(HttpStatus.OK)
    public User registerUser(@RequestBody RegisterUserDTO userDTO) {
        return userService.registerUser(userDTO);
    }
    //Logueo y Generación de Token
    @PostMapping("/login")
    public ResponseEntity<DtoAuthResponse> login(@RequestBody DtoLogin dtoLogin){
        return new ResponseEntity<>(userService.login(dtoLogin.getUser(), dtoLogin.getPassword()), HttpStatus.OK);
    }
    //Actualización de Usuario
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody User user) {
        Optional<User> usuarioExistente = userService.getByUsername(user.getUser());
        boolean userexists = userService.existsByUsuarioacceso(user.getUser());
        if(userexists){
            if (usuarioExistente.get().getIduser() == user.getIduser()){
                return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("El nombre de usuario se encuentra en uso", HttpStatus.BAD_REQUEST);
            }
        }
        else if (!userService.getUser(user.getIduser()).isPresent()){
            return new ResponseEntity<>("El usuario no existe", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
        }
    }
    // Eliminación de Usuario
    // -> Pasa a Inactivo
    // -> Vuelve a listar los Usuarios activos
    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> delete(@PathVariable("id") int userId){
        userService.delete(userId);
        return new ResponseEntity<>(userService.getAllActive(), HttpStatus.OK);
    }
}
