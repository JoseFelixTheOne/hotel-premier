package com.hotelpremier.Hotel.Premier.web.controller;

import com.hotelpremier.Hotel.Premier.domain.Room;
import com.hotelpremier.Hotel.Premier.domain.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping({"", "/"})
    public ResponseEntity<List<Room>> getAllActive(){
        return new ResponseEntity<>(roomService.getAllActive(), HttpStatus.OK);
    }
    @GetMapping("/inactive")
    public ResponseEntity<List<Room>> getAllInactive(){
        return new ResponseEntity<>(roomService.getAllInactive(), HttpStatus.OK);
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<Room>> getAll(){
        return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") int roomId){
        return roomService.getRoomById(roomId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/roomstatus/{roomStatusId}")
    public ResponseEntity<List<Room>> getRoomByRoomStatus(@PathVariable("roomStatusId") int roomStatusId){
        return roomService.getRoomByRoomStatus(roomStatusId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<Room>> getRoomsByFloor(@PathVariable("floorId") int floorId){
        return roomService.getRoomsByFloor(floorId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/roomtype/{roomTypeId}")
    public ResponseEntity<List<Room>> getRoomsByRoomType(@PathVariable("roomTypeId") int roomTypeId){
        return roomService.getRoomsByRoomType(roomTypeId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/roomstatusandfloor/{roomStatusId}/{floorId}")
    public ResponseEntity<List<Room>> getRoomsByRoomStatusAndFloor(@PathVariable("roomStatusId") int roomStatusId,@PathVariable("floorId") int floorId){
        return roomService.getRoomsByRoomStatusAndFloor(roomStatusId, floorId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/roomstatusandroomtype/{roomStatusId}/{roomTypeId}")
    public ResponseEntity<List<Room>> getRoomsByRoomStatusAndRoomType(@PathVariable("roomStatusId") int roomStatusId,@PathVariable("roomTypeId") int roomTypeId){
        return roomService.getRoomsByRoomStatusAndRoomType(roomStatusId, roomTypeId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/floorandroomtype/{floorId}/{roomTypeId}")
    public ResponseEntity<List<Room>> getRoomsByFloorAndRoomType(@PathVariable("floorId") int floorId,@PathVariable("roomTypeId") int roomTypeId){
        return roomService.getRoomsByFloorAndRoomType(floorId, roomTypeId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/roomstatusandfloorandroomtype/{roomStatusId}/{floorId}/{roomTypeId}")
    public ResponseEntity<List<Room>> getRoomsByRoomStatusAndFloorAndRoomType(@PathVariable("roomStatusId") int roomStatusId, @PathVariable("floorId") int floorId,@PathVariable("roomTypeId") int roomTypeId){
        return roomService.getRoomsByRoomStatusAndFloorAndRoomType(roomStatusId, floorId, roomTypeId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/roomnumber/{roomNumber}")
    public ResponseEntity<List<Room>> getRoomByRoomNumber(@PathVariable("roomNumber") int roomNumber){
        return roomService.getRoomByRoomNumber(roomNumber)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/")
    public ResponseEntity<Room> save(@RequestBody Room room){
        return new ResponseEntity<>(roomService.save(room), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Room> update(@RequestBody Room room){
        return new ResponseEntity<>(roomService.save(room), HttpStatus.OK);
    }
    @DeleteMapping("/{roomId}")
    public ResponseEntity<List<Room>> delete(@PathVariable("roomId") int roomId){
        roomService.delete(roomId);
        return new ResponseEntity<>(roomService.getAllActive(), HttpStatus.OK);
    }
}
