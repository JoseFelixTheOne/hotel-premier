package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository {
    List<Passenger> getAll();
    Optional<Passenger> getPassenger(int idpas);
    Passenger save(Passenger passenger);
    void delete(int idpas);
    boolean existsById(int idpas);
}
