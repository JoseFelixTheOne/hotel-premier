package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class DetalleReservaPK implements Serializable {
    @Column(name = "id_detallereserva")
    private Integer idDetalle;

    @Column(name = "id_reserva")
    private Integer idReserva;
}
