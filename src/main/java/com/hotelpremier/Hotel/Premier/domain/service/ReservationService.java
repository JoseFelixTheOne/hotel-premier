package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.Reservation;
import com.hotelpremier.Hotel.Premier.domain.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Transactional
    public Reservation reserve(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    //falta eliminacion logica
    public boolean delete(int reservationId) {
        if (getReservation(reservationId).isPresent()){
            reservationRepository.delete(reservationId);
            return true;
        } else {
            return false;
        }
    }

}
