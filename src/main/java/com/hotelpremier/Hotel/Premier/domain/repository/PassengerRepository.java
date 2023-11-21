package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import java.util.List;
import java.util.Optional;

public interface PassengerRepository {
    List<Passenger> getAll();
    List<Passenger> getAllActive();
    List<Passenger> getPassengerWithoutUser();
    Optional<Passenger> getPassengerById(int passengerid);
    Optional<List<Passenger>> getPassengerByNroDocumento(String nrodocumento);
    Optional<List<Passenger>> getPassengerByNombreApellido(String nombre);
    Optional<List<Passenger>> getPassengerByEmail(String email);
    Optional<List<Passenger>> getPassengerByPhone(String phone);
    Optional<Passenger> getPassenger(int idpas);
    Passenger save(Passenger passenger);
    void delete(int idpas);
    boolean existsById(int idpas);
}
