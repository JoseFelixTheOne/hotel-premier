package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.Room;
import com.hotelpremier.Hotel.Premier.persistence.entity.Habitacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = {EstateRoomMapper.class, FloorMapper.class, RoomTypeMapper.class})
public interface RoomMapper {

    @Mapping(source = "idHabitacion", target = "roomId")
    @Mapping(source = "numeroHabitacion", target = "roomNumber")
    @Mapping(source = "precioHabitacion", target = "roomPrice")
    @Mapping(source = "idEstadoHabitacion", target = "roomStatusId")
    @Mapping(source = "idPiso", target = "floorId")
    @Mapping(source = "idTipoHabitacion", target = "roomTypeId")
    @Mapping(source = "activoHabitacion", target = "roomActive")
    @Mapping(source = "objEstadoHabitacion", target = "objRoomStatus")
    @Mapping(source = "objPiso", target = "objFloor")
    @Mapping(source = "objTipoHabitacion", target = "objRoomType")
    Room toRoom(Habitacion habitacion);

    List<Room> toRooms(List<Habitacion> habitaciones);

    @InheritInverseConfiguration
    Habitacion toHabitacion(Room room);
}
