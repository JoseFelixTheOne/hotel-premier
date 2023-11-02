package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.domain.repository.UserRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.UsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
import com.hotelpremier.Hotel.Premier.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            var usuarios = usuarioCrudRepository.findAll();
            for(Usuario usuario : usuarios) {
                if(usuario.getActivo().equals("a")) {
                    lista.add(usuario);
                }
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return mapper.toUsers(lista);
    }

    @Override
    public Optional<User> getUser(int iduser) {
        return usuarioCrudRepository.findById(iduser).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public Optional<User> getByUsuarioaccesoAndClave(String user, String password) {
        return usuarioCrudRepository.getByUsuarioaccesoAndClave(user, password)
                .map(u -> mapper.toUser(u));
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int iduser) {
        Usuario usuario = usuarioCrudRepository.findById(iduser).orElse(new Usuario());
        usuario.setActivo("d");
        usuarioCrudRepository.save(usuario);
    }
}
