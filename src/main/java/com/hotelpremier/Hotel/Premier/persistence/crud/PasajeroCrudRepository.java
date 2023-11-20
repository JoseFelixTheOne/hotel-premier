package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Pasajero;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface PasajeroCrudRepository extends JpaRepository<Pasajero, Integer> {

    @Query(value = "SELECT * FROM tb_pasajero WHERE nrodoc_pasajero = :nrodocumento AND activo_pasajero = 'A'", nativeQuery = true)
    Optional<List<Pasajero>> getPassengerByNroDocumento(@Param("nrodocumento") String nrodocumento);
    @Query(value = "SELECT * FROM tb_pasajero where CONCAT(nombres_pasajero, ' ' , apellidopaterno_pasajero, ' ', apellidomaterno_pasajero) LIKE %:nombre%", nativeQuery = true)
    Optional<List<Pasajero>> getPasajeroByNombreApellido(@Param("nombre") String nombre);
    @Query(value = "SELECT * FROM tb_pasajero WHERE correo_pasajero LIKE %:correo% AND activo_pasajero = 'A'", nativeQuery = true)
    Optional<List<Pasajero>> getPasajeroByEmail(@Param("correo") String correo);
    @Query(value = "SELECT * FROM tb_pasajero WHERE telefono_pasajero LIKE %:telefono% AND activo_pasajero = 'A'", nativeQuery = true)
    Optional<List<Pasajero>> getPasajeroByPhone(@Param("telefono") String telefono);
    @Query(value = "SELECT * FROM tb_pasajero WHERE activo_pasajero = 'A'", nativeQuery = true)
    Optional<List<Pasajero>> findAllActive();
    boolean existsById(int idpas);
}
