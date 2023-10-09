package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.EstateRoom;
import com.hotelpremier.Hotel.Premier.domain.service.EstateRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estateroom")
public class EstateRoomController {
    @Autowired
    private EstateRoomService estateRoomService;

    @GetMapping("")
    public ResponseEntity<List<EstateRoom>> getAll() {
        return new ResponseEntity<>(estateRoomService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstateRoom> getEstateRoom(@PathVariable("id") int idestroom) {
        return estateRoomService.getEstateRoom(idestroom)
                .map(estate -> new ResponseEntity<>(estate, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<EstateRoom> save(@RequestBody EstateRoom estateRoom) {
        return new ResponseEntity<>(estateRoomService.save(estateRoom), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<EstateRoom> update(@RequestBody EstateRoom estateRoom) {
        return new ResponseEntity<>(estateRoomService.update(estateRoom), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int idestroom){
        return new ResponseEntity(estateRoomService.delete(idestroom) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
