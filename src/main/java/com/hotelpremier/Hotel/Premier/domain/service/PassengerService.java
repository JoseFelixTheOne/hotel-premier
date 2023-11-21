package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.repository.PassengerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PassengerService {

    private PassengerRepository passengerRepository;
    public List<Passenger> getAll() {

        return passengerRepository.getAll();
    }
    public List<Passenger> getAllActive(){
        return passengerRepository.getAllActive();
    }

    public Optional<List<Passenger>> getPassengerBynroDoc(String nrodocumento){
        return passengerRepository.getPassengerByNroDocumento(nrodocumento);
    }
    public Optional<List<Passenger>> getPassengerByNombreApellido(String nombre){
        return passengerRepository.getPassengerByNombreApellido(nombre);
    }
    public Optional<List<Passenger>> getPassengerByEmail(String email){
        return passengerRepository.getPassengerByEmail(email);
    }
    public Optional<List<Passenger>> getPassengerByPhone(String phone) {
        return passengerRepository.getPassengerByPhone(phone);
    }
    public Optional<Passenger> getPassenger(int idpas)  {
        return passengerRepository.getPassengerById(idpas);
    }
    public List<Passenger> getPassengerWithoutUser(){
        return passengerRepository.getPassengerWithoutUser();
    }
    public Passenger save(Passenger passenger) {
        passenger.setActive("A");
        passenger.setPassengerHasUser("0");
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
    public void delete(int idpas) {
        if (getPassenger(idpas).isPresent()) {
            Passenger passenger = passengerRepository.getPassengerById(idpas).get();
            passenger.setActive("I");
            passengerRepository.save(passenger);
        }else {
            System.out.println("ERROR 404 : PASSENGER "+ idpas +" NOT FOUND");
        }
    }
    public boolean existsById(int idpas){
        return passengerRepository.existsById(idpas);
    }
}
