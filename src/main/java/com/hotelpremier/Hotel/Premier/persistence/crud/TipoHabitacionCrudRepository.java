package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TipoHabitacionCrudRepository extends JpaRepository<TipoHabitacion, Integer> {
    @Query(value = "SELECT * FROM tb_tipohabitacion WHERE activo_tipohabitacion = 'A'", nativeQuery = true)
    Optional<List<TipoHabitacion>> findAllActive();
    @Query(value = "SELECT * FROM tb_tipohabitacion WHERE activo_tipohabitacion = 'I'", nativeQuery = true)
    Optional<List<TipoHabitacion>> findAllInactive();
}
