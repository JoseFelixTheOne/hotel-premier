package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.Reservation;
import com.hotelpremier.Hotel.Premier.domain.repository.ReservationRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.ReservaCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Reserva;
import com.hotelpremier.Hotel.Premier.persistence.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository implements ReservationRepository {
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    @Autowired
    private ReservationMapper mapper;
    @Override
    public List<Reservation> getAll() {
        return mapper.toReservations(reservaCrudRepository.findAll());
    }

    @Override
    public Optional<Reservation> getReservation(int reservationId) {
        return reservaCrudRepository.findById(reservationId).map(reserva -> mapper.toReservation(reserva));
    }

    @Override
    public Optional<Reservation> getByClient(int iduser) {
        return reservaCrudRepository.findByidUsuario(iduser).map(reserva -> mapper.toReservation(reserva));
    }

    @Override
    public Reservation save(Reservation reservation) {
        Reserva reserva = mapper.toReserva(reservation);
        reserva.getDetalles().forEach(detalle -> detalle.setReserva(reserva));
        return mapper.toReservation(reservaCrudRepository.save(reserva));
    }

    @Override
    public void delete(int reservationId) {
        reservaCrudRepository.deleteById(reservationId);
    }
}
