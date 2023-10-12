package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.RoomType;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoHabitacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {

    @Mapping(source = "id", target = "idroomtype")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "descripcion", target = "desc")
    @Mapping(source = "activo", target = "active")
    RoomType toRoomType(TipoHabitacion tipoHabitacion);
    List<RoomType> toRoomTypes(List<TipoHabitacion> tipoHabitaciones);

    @InheritInverseConfiguration
    TipoHabitacion toTipoHabitacion(RoomType roomType);
}
