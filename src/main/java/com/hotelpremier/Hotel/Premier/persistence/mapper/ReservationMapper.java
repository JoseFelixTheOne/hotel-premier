package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.Reservation;
import com.hotelpremier.Hotel.Premier.persistence.entity.Reserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DetailMapper.class})
public interface ReservationMapper {
    @Mapping(source = "idReserva", target = "reservationId")
    @Mapping(source = "idUsuario", target = "iduser")
    @Mapping(source = "fechaReserva", target = "date")
    @Mapping(source = "totalReserva", target = "total")
    @Mapping(source = "activoReserva", target = "active")
    @Mapping(source = "detalles",target = "details")
    Reservation toReservation(Reserva reserva);

    List<Reservation> toReservations(List<Reserva> reservas);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true)
    Reserva toReserva(Reservation reservation);

}
