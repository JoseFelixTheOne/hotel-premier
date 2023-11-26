package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.Reservation;
import com.hotelpremier.Hotel.Premier.domain.ReservationDetail;
import com.hotelpremier.Hotel.Premier.domain.dto.DateRangeDTO;
import com.hotelpremier.Hotel.Premier.domain.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Transactional
    public Reservation reserve(Reservation reservation){
        reservation.setTotal(calculateTotal(reservation.getDetails()));
        return reservationRepository.save(reservation);
    }
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    public Optional<List<Reservation>> getByClient(int iduser) {
        return reservationRepository.getByClient(iduser);
    }

    public Optional<List<Reservation>> getBetween(DateRangeDTO rangeDTO) {
        return reservationRepository.getBetween(rangeDTO.getStartDate(), rangeDTO.getEndDate());
    }

    public Optional<List<Reservation>> getByClientBetween(int iduser, DateRangeDTO rangeDTO) {
        return reservationRepository.getByClientBetween(iduser, rangeDTO.getStartDate(), rangeDTO.getEndDate());
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

    public BigDecimal calculateTotal(List<ReservationDetail> details) {
        BigDecimal total = BigDecimal.ZERO;
        for (ReservationDetail detail : details) {
            total = total.add(detail.getPrice());
        }

        return total;
    }

}
