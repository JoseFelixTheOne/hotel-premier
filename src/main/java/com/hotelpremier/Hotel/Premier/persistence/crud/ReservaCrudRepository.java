package com.hotelpremier.Hotel.Premier.persistence.crud;

import com.hotelpremier.Hotel.Premier.persistence.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaCrudRepository extends JpaRepository<Reserva, Integer> {
    Optional<List<Reserva>> findAllByidUsuario(Integer idUsuario);
    Optional<List<Reserva>> findAllByFechaReservaBetweenOrderByFechaReservaDesc(LocalDateTime start, LocalDateTime end);
    Optional<List<Reserva>> findAllByIdUsuarioAndFechaReservaBetweenOrderByFechaReservaDesc(Integer idUsuario,LocalDateTime start, LocalDateTime end);
}
