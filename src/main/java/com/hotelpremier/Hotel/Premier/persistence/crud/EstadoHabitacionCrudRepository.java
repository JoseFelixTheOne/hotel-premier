package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.EstadoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoHabitacionCrudRepository extends JpaRepository<EstadoHabitacion, Integer> {
}
