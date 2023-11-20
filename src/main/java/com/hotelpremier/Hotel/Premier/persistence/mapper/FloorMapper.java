package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.Floor;
import com.hotelpremier.Hotel.Premier.persistence.entity.Piso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FloorMapper {
    @Mapping(source = "id", target = "idfloor")
    @Mapping(source = "descripcion", target = "desc")
    @Mapping(source = "activo", target = "active")
    Floor toFloor(Piso piso);
    List<Floor> toFloors(List<Piso> pisos);

    @InheritInverseConfiguration
    Piso toPiso(Floor floor);
}
