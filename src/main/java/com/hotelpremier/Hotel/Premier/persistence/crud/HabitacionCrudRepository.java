package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface HabitacionCrudRepository extends JpaRepository<Habitacion, Integer> {
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_estadohabitacion = :roomStatusId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacion(@Param("roomStatusId") int roomStatusId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_piso = :floorId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> getRoomsByIdPiso(@Param("floorId") int floorId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_tipohabitacion = :roomTypeId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> getRoomsByIdTipoHabitacion(@Param("roomTypeId") int roomTypeId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_estadohabitacion = :roomStatusId AND id_piso = :floorId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacionAndIdPiso(@Param("roomStatusId") int roomStatusId, @Param("floorId") int floorId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_estadohabitacion = :roomStatusId AND id_tipohabitacion = :roomTypeId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacionAndIdTipoHabitacion(@Param("roomStatusId") int roomStatusId, @Param("roomTypeId") int roomTypeId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_piso = :floorId AND id_tipohabitacion = :roomTypeId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> getRoomsByIdPisoAndIdTipoHabitacion(@Param("floorId") int floorId, @Param("roomTypeId") int roomTypeId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE id_estadohabitacion = :roomStatusId AND id_piso = :floorId AND id_tipohabitacion = :roomTypeId AND activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> getRoomsByIdEstadoHabitacionAndIdPisoAndIdTipoHabitacion(@Param("roomStatusId") int roomStatusId, @Param("floorId") int floorId, @Param("roomTypeId") int roomTypeId);
    @Query(value = "SELECT * FROM tb_habitacion WHERE activo_habitacion = 'A'", nativeQuery = true)
    Optional<List<Habitacion>> findAllActive();
    @Query(value = "SELECT * FROM tb_habitacion WHERE activo_habitacion = 'I'", nativeQuery = true)
    Optional<List<Habitacion>> findAllInactive();
}
