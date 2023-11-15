package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TipoUsuarioCrudRepository extends JpaRepository<TipoUsuario, Integer> {

    @Query(value = "SELECT * FROM tb_tipousuario WHERE nombre_tipouser = :name AND activo_tipouser = 'A';", nativeQuery = true)
    Optional<TipoUsuario> getUserTypeByName(@Param("name") String name);
}
