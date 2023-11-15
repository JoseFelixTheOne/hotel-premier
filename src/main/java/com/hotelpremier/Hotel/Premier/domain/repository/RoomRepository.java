package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.Room;
import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    List<Room> getAll();
    List<Room> getAllActive();
    List<Room> getAllInactive();
    Optional<Room> getRoomById(int roomId);
    Optional<List<Room>> getRoomsByRoomStatus(int roomStatusId);
    Optional<List<Room>> getRoomsByFloor(int floorId);
    Optional<List<Room>> getRoomsByRoomType(int roomTypeId);
    Optional<List<Room>> getRoomsByRoomStatusAndFloor(int roomStatusId, int floorId);
    Optional<List<Room>> getRoomsByRoomStatusAndRoomType(int roomStatusId, int roomTypeId);
    Optional<List<Room>> getRoomsByFloorAndRoomType(int floorId, int roomTypeId);
    Optional<List<Room>> getRoomsByRoomStatusAndFloorAndRoomType(int roomStatusId, int floorId, int roomTypeId);
    Room save(Room room);
    void delete(int roomId);
}
