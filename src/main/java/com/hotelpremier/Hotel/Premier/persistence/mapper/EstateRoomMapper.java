package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.EstateRoom;
import com.hotelpremier.Hotel.Premier.persistence.entity.EstadoHabitacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EstateRoomMapper {
    @Mapping(source = "id", target = "idestroom")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "activo", target = "active")
    EstateRoom toEstateRoom(EstadoHabitacion estadoHabitacion);
    List<EstateRoom> toEstateRooms(List<EstadoHabitacion> estadoHabitaciones);

    @InheritInverseConfiguration
    EstadoHabitacion toEstadoHabitacion(EstateRoom estateRoom);

}
