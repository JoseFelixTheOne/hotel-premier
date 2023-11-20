package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.repository.PassengerRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.PasajeroCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Pasajero;
import com.hotelpremier.Hotel.Premier.persistence.mapper.PassengerMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PasajeroRepository implements PassengerRepository {

    private PasajeroCrudRepository pasajeroCrudRepository;

    private PassengerMapper mapper;
    @Override
    public List<Passenger> getAll() {
        List<Pasajero> pasajeros = pasajeroCrudRepository.findAll();
        return mapper.toPassengers(pasajeros);
    }

    @Override
    public List<Passenger> getAllActive() {
        List<Pasajero> pasajeros = pasajeroCrudRepository.findAllActive().get();
        return mapper.toPassengers(pasajeros);
    }

    @Override
    public Optional<Passenger> getPassengerById(int passengerid) {
        return pasajeroCrudRepository.findById(passengerid).map(p -> mapper.toPassenger(p));
    }

    @Override
    public Optional<List<Passenger>> getPassengerByNroDocumento(String nrodocumento) {
        return pasajeroCrudRepository.getPassengerByNroDocumento(nrodocumento).map(p -> mapper.toPassengers(p));
    }

    @Override
    public Optional<List<Passenger>> getPassengerByNombreApellido(String nombre) {
        return pasajeroCrudRepository.getPasajeroByNombreApellido(nombre)
                .map(p -> mapper.toPassengers(p));
    }

    @Override
    public Optional<List<Passenger>> getPassengerByEmail(String email) {
        return pasajeroCrudRepository.getPasajeroByEmail(email)
                .map(p -> mapper.toPassengers(p));
    }

    @Override
    public Optional<List<Passenger>> getPassengerByPhone(String phone) {
        return pasajeroCrudRepository.getPasajeroByPhone(phone)
                .map(p -> mapper.toPassengers(p));
    }

    @Override
    public Optional<Passenger> getPassenger(int idpas) {
        return pasajeroCrudRepository.findById(idpas).map(pasajero -> mapper.toPassenger(pasajero));
    }
    @Override
    public Passenger save(Passenger passenger) {
        return mapper.toPassenger(pasajeroCrudRepository.save(mapper.toPasajero(passenger)));
    }
    @Override
    public void delete(int idpas) {
        System.out.println("SE ELIMINÓ CORRECTAMENTE EL PASAJERO CON ID: " + idpas);
    }
    @Override
    public boolean existsById(int idpas) {
        return pasajeroCrudRepository.existsById(idpas);
    }
}
