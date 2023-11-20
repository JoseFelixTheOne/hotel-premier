package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.RoomType;
import com.hotelpremier.Hotel.Premier.domain.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roomtypes")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;
    @GetMapping("/")
    public ResponseEntity<List<RoomType>> getAll() {
        return new ResponseEntity<>(roomTypeService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomType(@PathVariable("id") int idroomtype) {
        return roomTypeService.getRoomType(idroomtype)
                .map(type -> new ResponseEntity<>(type, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<RoomType> save(@RequestBody RoomType roomType) {
        return new ResponseEntity<>(roomTypeService.save(roomType), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<RoomType> update(@RequestBody RoomType roomType) {
        return new ResponseEntity<>(roomTypeService.update(roomType), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int idroomtype) {
        return new ResponseEntity(roomTypeService.delete(idroomtype) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
