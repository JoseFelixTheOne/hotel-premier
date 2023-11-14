package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();

    List<User> getAllActive();

    List<User> getAllInactive();

    Optional<User> getUser(int iduser);

    Optional<User> getByUserusuarioAndClave(String username, String password);

    Optional<User> getUserForLogin(String user);

    List<User> getByNombreusuario(String user);

    User save(User user);

    void delete(int iduser);
}
