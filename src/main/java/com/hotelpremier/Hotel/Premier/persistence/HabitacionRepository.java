package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.Room;
import com.hotelpremier.Hotel.Premier.domain.repository.RoomRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.HabitacionCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class HabitacionRepository implements RoomRepository {
    @Autowired
    private HabitacionCrudRepository habitacionCrudRepository;
    @Autowired
    private RoomMapper mapper;
    @Override
    public List<Room> getAll() {
        return mapper.toRooms(habitacionCrudRepository.findAll());
    }

    @Override
    public List<Room> getAllActive() {
        return mapper.toRooms(habitacionCrudRepository.findAllActive().get());
    }

    @Override
    public List<Room> getAllInactive() {
        return mapper.toRooms(habitacionCrudRepository.findAllInactive().get());
    }

    @Override
    public Optional<Room> getRoomById(int roomId) {
        return habitacionCrudRepository.findById(roomId)
                .map(r -> mapper.toRoom(r));
    }
    @Override
    public Optional<List<Room>> getRoomsByRoomStatus(int roomStatusId) {
        return habitacionCrudRepository.findRoomsByIdEstadoHabitacion(roomStatusId)
                .map(r -> mapper.toRooms(r));
    }
    @Override
    public Optional<List<Room>> getRoomsByFloor(int floorId) {
        return habitacionCrudRepository.findRoomsByIdPiso(floorId)
                .map(r -> mapper.toRooms(r));
    }
    @Override
    public Optional<List<Room>> getRoomsByRoomType(int roomTypeId) {
        return habitacionCrudRepository.findRoomsByIdTipoHabitacion(roomTypeId)
                .map(r -> mapper.toRooms(r));
    }
    @Override
    public Optional<List<Room>> getRoomsByRoomStatusAndFloor(int roomStatusId, int floorId) {
        return habitacionCrudRepository.findRoomsByIdEstadoHabitacionAndIdPiso(roomStatusId, floorId)
                .map(r -> mapper.toRooms(r));
    }
    @Override
    public Optional<List<Room>> getRoomsByRoomStatusAndRoomType(int roomStatusId, int roomTypeId) {
        return habitacionCrudRepository.findRoomsByIdEstadoHabitacionAndIdTipoHabitacion(roomStatusId, roomTypeId)
                .map(r -> mapper.toRooms(r));
    }
    @Override
    public Optional<List<Room>> getRoomsByFloorAndRoomType(int floorId, int roomTypeId) {
        return habitacionCrudRepository.findRoomsByIdPisoAndIdTipoHabitacion(floorId, roomTypeId)
                .map(r -> mapper.toRooms(r));
    }
    @Override
    public Optional<List<Room>> getRoomsByRoomStatusAndFloorAndRoomType(int roomStatusId, int floorId, int roomTypeId) {
        return habitacionCrudRepository.findRoomsByIdEstadoHabitacionAndIdPisoAndIdTipoHabitacion(roomStatusId, floorId, roomTypeId)
                .map(r -> mapper.toRooms(r));
    }
    @Override
    public Room save(Room room) {
        return mapper.toRoom(habitacionCrudRepository.save(mapper.toHabitacion(room)));
    }
    @Override
    public void delete(int roomId) {
        habitacionCrudRepository.deleteById(roomId);
    }
}
