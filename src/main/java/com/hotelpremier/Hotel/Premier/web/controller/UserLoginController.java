package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.persistence.crud.TipoUsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.UsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuario;
import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
import com.hotelpremier.Hotel.Premier.web.dtosecurity.DtoRegistro;
import com.hotelpremier.Hotel.Premier.web.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserLoginController {

    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private TipoUsuarioCrudRepository tipoUsuarioCrudRepository;
    private UsuarioCrudRepository usuarioCrudRepository;
    private JwtGenerator jwtGenerator;

    @Autowired
    public UserLoginController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, TipoUsuarioCrudRepository tipoUsuarioCrudRepository, UsuarioCrudRepository usuarioCrudRepository, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.tipoUsuarioCrudRepository = tipoUsuarioCrudRepository;
        this.usuarioCrudRepository = usuarioCrudRepository;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/usuario/")
    public ResponseEntity<String> saveUsuario(@RequestBody DtoRegistro dtoRegistro){
        System.out.println(dtoRegistro.getUsername());
        System.out.println(dtoRegistro.getUsertpe());
        System.out.println(dtoRegistro.getIduser());
        System.out.println(dtoRegistro.getPassword());
        System.out.println(dtoRegistro.getActive());
        System.out.println(dtoRegistro.getIdpassenger());
        boolean exists = usuarioCrudRepository.existsByUsuarioacceso(dtoRegistro.getUsername());
        if(exists){
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario();
        usuario.setIdpasajero(dtoRegistro.getIdpassenger());
        usuario.setUsuarioacceso(dtoRegistro.getUsername());
        usuario.setClave(passwordEncoder.encode(dtoRegistro.getPassword()));
        usuario.setActivo("A");
        TipoUsuario tipoUsuario = tipoUsuarioCrudRepository.getById(dtoRegistro.getUsertpe());
        usuario.setTipousuario(tipoUsuario.getIdTipouser());
        usuarioCrudRepository.save(usuario);

        return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
    }

}
