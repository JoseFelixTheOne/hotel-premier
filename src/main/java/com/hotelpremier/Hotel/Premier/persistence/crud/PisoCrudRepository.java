package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PisoCrudRepository extends JpaRepository<Piso, Integer> {
    @Query(value = "SELECT * FROM tb_piso WHERE activo_piso = 'A'", nativeQuery = true)
    Optional<List<Piso>> findAllActive();
    @Query(value = "SELECT * FROM tb_piso WHERE activo_piso = 'I'", nativeQuery = true)
    Optional<List<Piso>> findAllInactive();
}
