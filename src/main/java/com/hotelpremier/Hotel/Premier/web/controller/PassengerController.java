package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/passenger")
@AllArgsConstructor
public class PassengerController {

    private PassengerService passengerService;
    @GetMapping({"","/"})
    public ResponseEntity<List<Passenger>> getAllActive() {
        return new ResponseEntity<>(passengerService.getAllActive(), HttpStatus.OK);
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<Passenger>> getAll() {
        return new ResponseEntity<>(passengerService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable("id") int idpas) {
        return passengerService.getPassenger(idpas)
                .map(passenger -> new ResponseEntity<>(passenger, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/listWithoutUser")
    public ResponseEntity<List<Passenger>> getPassengerWithoutUser(){
        return new ResponseEntity<>(passengerService.getPassengerWithoutUser(), HttpStatus.OK);
    }

    @GetMapping("/name/{nombre}")
    public ResponseEntity<List<Passenger>> getPassengerByNombreApellido(@PathVariable("nombre") String nombre) {
        return passengerService.getPassengerByNombreApellido(nombre)
                .map(p -> new ResponseEntity<>(p,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{correo}")
    public  ResponseEntity<List<Passenger>> getPassengerByEmail(@PathVariable("correo") String correo) {
        return passengerService.getPassengerByEmail(correo)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/phone/{telefono}")
    public ResponseEntity<List<Passenger>> getPassengerByPhone(@PathVariable("telefono") String telefono) {
        return passengerService.getPassengerByPhone(telefono)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Passenger> save(@RequestBody Passenger passenger) {
        return new ResponseEntity<>(passengerService.save(passenger), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Passenger> update(@RequestBody Passenger passenger){
        return new ResponseEntity<>(passengerService.update(passenger), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Passenger>> delete(@PathVariable("id") int idpas){
       passengerService.delete(idpas);
       return new ResponseEntity<>(passengerService.getAllActive(),HttpStatus.OK);
    }
}
