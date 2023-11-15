package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.repository.PassengerRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.PasajeroCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Pasajero;
import com.hotelpremier.Hotel.Premier.persistence.mapper.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PasajeroRepository implements PassengerRepository {
    @Autowired
    private PasajeroCrudRepository pasajeroCrudRepository;
    @Autowired
    private PassengerMapper mapper;
    @Override
    public List<Passenger> getAll() {
        List<Pasajero> pasajeros = pasajeroCrudRepository.findAll();
        return mapper.toPassengers(pasajeros);
    }
    @Override
    public Optional<Passenger> getPassenger(int idpas) {
        return pasajeroCrudRepository.findById(idpas).map(pasajero -> mapper.toPassenger(pasajero));
    }
    @Override
    public Passenger save(Passenger passenger) {
        Pasajero pasajero = mapper.toPasajero(passenger);
        return mapper.toPassenger(pasajeroCrudRepository.save(pasajero));
    }
    @Override
    public void delete(int idpas) {
        pasajeroCrudRepository.deleteById(idpas);
    }
    @Override
    public boolean existsById(int idpas) {
        return pasajeroCrudRepository.existsById(idpas);
    }
}
