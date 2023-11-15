package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();

    List<User> getAllActive();

    List<User> getAllInactive();

    Optional<User> getUser(int iduser);

    List<User> getByNombreusuario(String user);

    User save(User user);

    void delete(int iduser);
    boolean existsByUsuarioacceso(String username);
    boolean existsByIdpasajero(int idpasajero);
}
