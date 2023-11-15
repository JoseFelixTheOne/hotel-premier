package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.User;
import com.hotelpremier.Hotel.Premier.domain.repository.UserRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.UsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
import com.hotelpremier.Hotel.Premier.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository{
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;
    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> getAll() {
        List<Usuario> usuarios = usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }
    @Override
    public List<User> getAllActive() {
        List<Usuario> usuarios = usuarioCrudRepository.findAllActive().get();
        return mapper.toUsers(usuarios);
    }
    @Override
    public List<User> getAllInactive() {
        List<Usuario> usuarios = usuarioCrudRepository.findAllInactive().get();
        return mapper.toUsers(usuarios);
    }
    @Override
    public Optional<User> getUser(int iduser) {
        return usuarioCrudRepository.findById(iduser).map(usuario -> mapper.toUser(usuario));
    }
    @Override
    public List<User> getByNombreusuario(String user){
        List<Usuario> usuarios = usuarioCrudRepository.findByNombreusuario(user).get();
        return mapper.toUsers(usuarios);
    }
    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }
    @Override
    public void delete(int iduser) {
        System.out.println("SE ELIMINÓ CORRECTAMENTE AL USUARIO CON ID: " + iduser);
    }
    @Override
    public boolean existsByUsuarioacceso(String username) {
        return usuarioCrudRepository.existsByUsuarioacceso(username);
    }
    @Override
    public boolean existsByIdpasajero(int tipousuario) {
        return usuarioCrudRepository.existsByIdpasajero(tipousuario);
    }
}
