package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaCrudRepository extends JpaRepository<Reserva, Integer> {
    Optional<Reserva> findByidUsuario(Integer idUsuario);
}
