package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.Room;
import com.hotelpremier.Hotel.Premier.domain.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public List<Room> getAll(){
        return roomRepository.getAll();
    }
    public List<Room> getAllActive(){
        return roomRepository.getAllActive();
    }
    public List<Room> getAllInactive(){
        return roomRepository.getAllInactive();
    }
    public Optional<Room> getRoomById(int roomId){
        return roomRepository.getRoomById(roomId);
    }
    public Optional<List<Room>> getRoomByRoomStatus(int roomStatusId){
        return roomRepository.getRoomsByRoomStatus(roomStatusId);
    }
    public Optional<List<Room>> getRoomsByFloor(int floorId){
        return roomRepository.getRoomsByFloor(floorId);
    }
    public Optional<List<Room>> getRoomsByRoomType(int roomTypeId){
        return roomRepository.getRoomsByRoomType(roomTypeId);
    }
    public Optional<List<Room>> getRoomsByRoomStatusAndFloor(int roomStatusId, int floorId){
        return roomRepository.getRoomsByRoomStatusAndFloor(roomStatusId, floorId);
    }
    public Optional<List<Room>> getRoomsByRoomStatusAndRoomType(int roomStatusId, int roomTypeId){
        return roomRepository.getRoomsByRoomStatusAndRoomType(roomStatusId, roomTypeId);
    }
    public Optional<List<Room>> getRoomsByFloorAndRoomType(int floorId, int roomTypeId){
        return roomRepository.getRoomsByFloorAndRoomType(floorId, roomTypeId);
    }
    public Optional<List<Room>> getRoomsByRoomStatusAndFloorAndRoomType(int roomStatusId, int floorId, int roomTypeId){
        return roomRepository.getRoomsByRoomStatusAndFloorAndRoomType(roomStatusId, floorId, roomTypeId);
    }
    public Room save(Room room){
        room.setRoomActive("A");
        return roomRepository.save(room);
    }
    public Room update(Room room){
        int roomId = room.getRoomId();
        Room r = getRoomById(roomId).map(m ->{
            BeanUtils.copyProperties(room, m);
            return m;
        }).orElseThrow(() -> new EntityNotFoundException("Room not found with ID: " + roomId));
        return roomRepository.save(r);
    }
    public void delete(int roomId){
        if(getRoomById(roomId).isPresent()) {
            Room room = roomRepository.getRoomById(roomId).get();
            room.setRoomActive("I");
            roomRepository.save(room);
        }else{
            System.out.println("ERROR 404 : ROOM "+ roomId +" NOT FOUND");
        }
    }
}