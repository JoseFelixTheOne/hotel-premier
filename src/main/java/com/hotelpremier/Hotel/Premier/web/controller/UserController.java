package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.domain.UserType;
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
        return new ResponseEntity<>(userService.getByNombreusuario(username), HttpStatus.OK);

    }
    //Registro de Usuario
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody DtoRegistro dtoRegistro){
        boolean userexists = userService.existsByUsuarioacceso(dtoRegistro.getUser());
        boolean passengerexists = passengerService.existsById(dtoRegistro.getIdpassenger());
        boolean passengerhasuser = userService.existsByIdpasajero(dtoRegistro.getIdpassenger());
        if(userexists){
            return new ResponseEntity<>("El nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        else if (!passengerexists){
            return new ResponseEntity<>("El pasajero no existe", HttpStatus.BAD_REQUEST);
        }
        else if(passengerhasuser){
            return new ResponseEntity<>("El pasajero ya tiene un usuario", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setIdpassenger(dtoRegistro.getIdpassenger());
        user.setUser(dtoRegistro.getUser());
        user.setPassword(passwordEncoder.encode(dtoRegistro.getPassword()));
        Optional<UserType> tipoUsuario = userTypeService.getUserType(dtoRegistro.getUsertpe());
        user.setUsertpe(tipoUsuario.get().getUserTypeId());
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    //Logueo y Generación de Token
    @PostMapping("/login")
    public ResponseEntity<DtoAuthResponse> login(@RequestBody DtoLogin dtoLogin){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoLogin.getUser(), dtoLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generarToken(authentication);
        String username = jwtGenerator.obtenerUsernameDeJwt(token);
        List<User> user = userService.getByNombreusuario(username);
        int userId = user.get(0).getIduser();
        String name = user.get(0).getObjPassenger().getNames();
        String lastname1 = user.get(0).getObjPassenger().getLastname1();
        String lastname2 = user.get(0).getObjPassenger().getLastname2();
        return new ResponseEntity<>(new DtoAuthResponse(token, username , userId, name, lastname1, lastname2), HttpStatus.OK);
    }
    //Actualización de Usuario
    @PutMapping("/")
    public ResponseEntity<User> update(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
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
