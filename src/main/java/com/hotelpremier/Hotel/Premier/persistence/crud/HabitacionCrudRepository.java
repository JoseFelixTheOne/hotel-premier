package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.domain.Room;
import com.hotelpremier.Hotel.Premier.persistence.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HabitacionCrudRepository extends JpaRepository<Habitacion, Integer> {
    @Query(value = "SELECT * FROM tb_habitacion WHERE activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> findAllActive();
    @Query(value = "SELECT * FROM tb_habitacion WHERE activo_habitacion = 'I'", nativeQuery = true)
    Optional<List<Habitacion>> findAllInactive();
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_estadohabitacion = :statusId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> findRoomsByIdEstadoHabitacion(@Param("statusId") int roomStatusId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_piso = :floorId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> findRoomsByIdPiso(@Param("floorId") int floorId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_tipohabitacion = :typeId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> findRoomsByIdTipoHabitacion(@Param("typeId") int roomTypeId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_estadohabitacion = :statusId AND id_piso = :floorId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> findRoomsByIdEstadoHabitacionAndIdPiso(@Param("statusId") int roomStatusId, @Param("floorId") int floorId);
    Optional<List<Habitacion>> findRoomsByIdEstadoHabitacionAndIdTipoHabitacion(int roomStatusId, int roomTypeId);
    Optional<List<Habitacion>> findRoomsByIdPisoAndIdTipoHabitacion(int floorId, int roomTypeId);
    Optional<List<Habitacion>> findRoomsByIdEstadoHabitacionAndIdPisoAndIdTipoHabitacion(int roomStatusId, int floorId, int roomTypeId);
}
