package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.repository.PassengerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAll() {
        return passengerRepository.getAll();
    }

    public Optional<Passenger> getPassenger(int idpas)  {
        return passengerRepository.getPassenger(idpas);
    }

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger update(Passenger passenger) {
        int idpas = passenger.getIdpas();
        Passenger  pasajero = getPassenger(idpas).map(p ->{
            BeanUtils.copyProperties(passenger, p);
            return p;
        }).orElseThrow(() -> new EntityNotFoundException("Passenger not found with ID: " + idpas));
        return passengerRepository.save(pasajero);
    }

    public boolean delete(int idpas) {
        if (getPassenger(idpas).isPresent()) {
            passengerRepository.delete(idpas);
            return true;
        }else {
            return false;
        }
    }
    public boolean existsById(int idpas){
        return passengerRepository.existsById(idpas);
    }
}
