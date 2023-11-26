package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Reservation;
import com.hotelpremier.Hotel.Premier.domain.dto.DateRangeDTO;
import com.hotelpremier.Hotel.Premier.domain.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> reserve(@Valid @RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.reserve(reservation), HttpStatus.CREATED);
    }
    @GetMapping({"", "/"})
    public ResponseEntity<List<Reservation>> getAll() {
        return new ResponseEntity<>(reservationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{iduser}/my-reservations")
    public ResponseEntity<List<Reservation>> getByClient(@PathVariable int iduser){
        return ResponseEntity.of(reservationService.getByClient(iduser));
    }

    @PostMapping("between-range")
    public ResponseEntity<List<Reservation>> getBetween(@RequestBody DateRangeDTO rangeDTO) {
        return ResponseEntity.of(reservationService.getBetween(rangeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return reservationService.getReservation(reservationId)
                .map(reservation -> new ResponseEntity<>(reservation, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
