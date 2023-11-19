package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.ReservationDetail;
import com.hotelpremier.Hotel.Premier.persistence.entity.DetalleReserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoomMapper.class})
public interface DetailMapper {

    @Mapping(source = "id.idDetalle", target = "detailId")
    @Mapping(source = "idHabitacion", target = "roomId")
    @Mapping(source = "checkinReserva", target = "checkin")
    @Mapping(source = "checkoutReserva", target = "checkout")
    @Mapping(source = "precioReserva", target = "price")
    @Mapping(source = "observacionReserva", target = "note")
    @Mapping(source = "habitacion", target = "room")
    @Mapping(source = "reserva", target = "reservation")
    ReservationDetail toDetail(DetalleReserva detalle);
    List<ReservationDetail> toDetails(List<DetalleReserva> detalles);

    @InheritInverseConfiguration
    @Mapping(target = "reserva", ignore = true)
    @Mapping(target = "habitacion", ignore = true)
    @Mapping(target = "id.idReserva", ignore = true)
    DetalleReserva toDetalle(ReservationDetail detail);
}
