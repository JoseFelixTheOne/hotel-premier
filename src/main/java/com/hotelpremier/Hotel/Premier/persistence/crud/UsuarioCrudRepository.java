package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioCrudRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> getByUsuarioaccesoAndClave(String user, String password);
}
