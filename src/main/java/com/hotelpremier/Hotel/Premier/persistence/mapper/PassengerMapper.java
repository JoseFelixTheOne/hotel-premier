package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.persistence.entity.Pasajero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = {DocTypeMapper.class})
public interface PassengerMapper {
    @Mapping(source = "idpasajero",target = "idpas")
    @Mapping(source = "idtpodocumento", target = "idtpodoc")
    @Mapping(source = "nrodocumento", target = "nrodoc")
    @Mapping(source = "nombres", target = "names")
    @Mapping(source = "apellidopaterno", target = "lastname1")
    @Mapping(source = "apellidomaterno", target = "lastname2")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "telefono", target = "phone")
    @Mapping(source = "activo", target = "active")
    @Mapping(source = "objTpoDoc", target = "docType")
    @Mapping(source = "btieneusuarioPasajero", target = "passengerHasUser")
    Passenger toPassenger(Pasajero pasajero);
    List<Passenger> toPassengers(List<Pasajero> pasajeros);

    @InheritInverseConfiguration
    Pasajero toPasajero(Passenger passenger);
}
