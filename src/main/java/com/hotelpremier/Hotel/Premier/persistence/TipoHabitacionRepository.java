package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.RoomType;
import com.hotelpremier.Hotel.Premier.domain.repository.RoomTypeRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.TipoHabitacionCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoHabitacion;
import com.hotelpremier.Hotel.Premier.persistence.mapper.RoomTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoHabitacionRepository implements RoomTypeRepository {
    @Autowired
    private TipoHabitacionCrudRepository tipoHabitacionCrudRepository;

    @Autowired
    private RoomTypeMapper mapper;

    @Override
    public List<RoomType> getAll() {
        List<TipoHabitacion> tipos = tipoHabitacionCrudRepository.findAll();
        return mapper.toRoomTypes(tipos);
    }

    @Override
    public Optional<RoomType> getRoomType(int idroomtype) {
        return tipoHabitacionCrudRepository.findById(idroomtype).map(tipo -> mapper.toRoomType(tipo));
    }

    @Override
    public RoomType save(RoomType roomType) {
        TipoHabitacion tipo = mapper.toTipoHabitacion(roomType);
        return mapper.toRoomType(tipoHabitacionCrudRepository.save(tipo));
    }

    @Override
    public void delete(int idroomtype) {
        tipoHabitacionCrudRepository.deleteById(idroomtype);
    }
}
