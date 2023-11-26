package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    List<Reservation> getAll();
    Optional<Reservation> getReservation(int reservationId);
    Optional<List<Reservation>> getByClient(int iduser);
    Reservation save(Reservation reservation);
    void delete(int reservationId);
    Optional<List<Reservation>> getBetween(LocalDateTime start, LocalDateTime end);
}
