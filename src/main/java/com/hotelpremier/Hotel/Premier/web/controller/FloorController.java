package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Floor;
import com.hotelpremier.Hotel.Premier.domain.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/floor")
public class FloorController {
    @Autowired
    private FloorService floorService;
    @GetMapping("")
    public ResponseEntity<List<Floor>> getAll() {
        return new ResponseEntity<>(floorService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable("id") int idfloor) {
        return floorService.getFloor(idfloor)
                .map(floor -> new ResponseEntity<>(floor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Floor> save(@RequestBody Floor floor) {
        return new ResponseEntity<>(floorService.save(floor), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Floor> update(@RequestBody Floor floor) {
        return new ResponseEntity<>(floorService.update(floor), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity delete(@PathVariable("id") int idfloor) {
        return new ResponseEntity(floorService.delete(idfloor) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
