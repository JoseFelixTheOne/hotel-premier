package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoHabitacionCrudRepository extends JpaRepository<TipoHabitacion, Integer> {
}
