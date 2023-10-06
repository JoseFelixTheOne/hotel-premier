package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{
    List<User> getAll();
    Optional<User> getUser(int iduser);
    Optional<User> getByUsuarioaccesoAndClave(String user, String password);
    User save(User user);
    void delete(int iduser);
}
