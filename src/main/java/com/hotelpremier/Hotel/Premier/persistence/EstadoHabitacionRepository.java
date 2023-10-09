package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.EstateRoom;
import com.hotelpremier.Hotel.Premier.domain.repository.EstateRoomRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.EstadoHabitacionCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.EstadoHabitacion;
import com.hotelpremier.Hotel.Premier.persistence.mapper.EstateRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstadoHabitacionRepository implements EstateRoomRepository {
    @Autowired
    private EstadoHabitacionCrudRepository estadoHabitacionCrudRepository;

    @Autowired
    private EstateRoomMapper mapper;

    @Override
    public List<EstateRoom> getAll() {
        List<EstadoHabitacion> estados = estadoHabitacionCrudRepository.findAll();
        return mapper.toEstateRooms(estados);
    }

    @Override
    public Optional<EstateRoom> getEstateRoom(int idestroom) {
        return estadoHabitacionCrudRepository.findById(idestroom).map(estado -> mapper.toEstateRoom(estado));
    }

    @Override
    public EstateRoom save(EstateRoom estateRoom) {
        EstadoHabitacion estado = mapper.toEstadoHabitacion(estateRoom);
        return mapper.toEstateRoom(estadoHabitacionCrudRepository.save(estado));
    }

    @Override
    public void delete(int idestroom) {
        estadoHabitacionCrudRepository.deleteById(idestroom);
    }
}
