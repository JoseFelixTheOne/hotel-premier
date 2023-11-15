package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
    @GetMapping("")
    public ResponseEntity<List<Passenger>> getAll() {
        return new ResponseEntity<>(passengerService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable("id") int idpas) {
        return passengerService.getPassenger(idpas)
                .map(passenger -> new ResponseEntity<>(passenger, HttpStatus.OK))
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

    @DeleteMapping("/deletepass/{id}")
    public ResponseEntity delete(@PathVariable("id") int idpas){
        return new ResponseEntity(passengerService.delete(idpas) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
