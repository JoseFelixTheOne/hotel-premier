package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.domain.Room;
import com.hotelpremier.Hotel.Premier.persistence.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HabitacionCrudRepository extends JpaRepository<Habitacion, Integer> {
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacion(int roomStatusId);
    Optional<List<Habitacion>> getRoomsByIdPiso(int floorId);
    Optional<List<Habitacion>> getRoomsByIdTipoHabitacion(int roomTypeId);
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacionAndIdPiso(int roomStatusId, int floorId);
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacionAndIdTipoHabitacion(int roomStatusId, int roomTypeId);
    Optional<List<Habitacion>> getRoomsByIdPisoAndIdTipoHabitacion(int floorId, int roomTypeId);
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacionAndIdPisoAndIdTipoHabitacion(int roomStatusId, int floorId, int roomTypeId);
}
