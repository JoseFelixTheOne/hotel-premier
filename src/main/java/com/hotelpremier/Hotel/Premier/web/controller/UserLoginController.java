package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.domain.service.PassengerService;
import com.hotelpremier.Hotel.Premier.domain.service.UserService;
import com.hotelpremier.Hotel.Premier.domain.service.UserTypeService;
import com.hotelpremier.Hotel.Premier.persistence.crud.PasajeroCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.TipoUsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.UsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuario;
import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtGenerator jwtGenerator;
    @Autowired
    private UserService userService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private UserTypeService userTypeService;

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody DtoRegistro dtoRegistro){
        boolean userexists = userService.existsByUsuarioacceso(dtoRegistro.getUsername());
        boolean passengerexists = passengerService.existsById(dtoRegistro.getIdpassenger());
        boolean passengerhasuser = userService.existsByIdpasajero(dtoRegistro.getIdpassenger());
        if(userexists){
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        else if (!passengerexists){
            return new ResponseEntity<>("El pasajero no existe", HttpStatus.BAD_REQUEST);
        }
        else if(passengerhasuser){
            return new ResponseEntity<>("El pasajero ya tiene un usuario", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setIdpassenger(dtoRegistro.getIdpassenger());
        user.setUser(dtoRegistro.getUsername());
        user.setPassword(passwordEncoder.encode(dtoRegistro.getPassword()));
        Optional<UserType> tipoUsuario = userTypeService.getUserType(dtoRegistro.getUsertpe());
        user.setUsertpe(tipoUsuario.get().getUserTypeId());
        userService.save(user);

        return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
    }
    //Método para poder loguear y obtener un token
    @PostMapping("/login")
    public ResponseEntity<DtoAuthResponse> login(@RequestBody DtoLogin dtoLogin){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoLogin.getUsername(), dtoLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generarToken(authentication);
        return new ResponseEntity<>(new DtoAuthResponse(token), HttpStatus.OK);

    }
}
